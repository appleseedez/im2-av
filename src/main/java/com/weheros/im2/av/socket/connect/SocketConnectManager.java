/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket.connect;

import java.util.HashMap;
import java.util.Map;

import org.apache.mina.core.session.IoSession;

import com.weheros.im2.av.domain.SessionTokenService;
import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.domain.SignalType;

/**
 * @ClassName: RegistryManager
 * @author Administrator
 * @date 2014年4月3日 下午6:07:51
 */
public class SocketConnectManager implements IConnectManager {
	
	private static Map<String,AVConnection> pools=new HashMap<String,AVConnection>();
	public static SocketConnectManager manager=null;
	public static SocketConnectManager getInstance(){
		if(null==manager){
			manager=new SocketConnectManager();
		}
		return manager;
	}
	private SocketConnectManager(){
		
	}

	@Override
	public void register(String account,IoSession session) {
		AVConnection avc=new AVConnection(session,account);
		pools.put(account, avc);
		
	}

	@Override
	public void remove(String account) {
		pools.remove(account);
	}

	@Override
	public void maintainConnection(IoSession session, Signal signal) {
		if(SignalType.HEART_BEAT==signal.getHead().getSignalType()){
			//update the status of connection.
			String sessiontoken=signal.getHead().getSessionToken();
			//find account
			String accountKey=SessionTokenService.getAccount(sessiontoken);
			AVConnection anthoer=new AVConnection(session,accountKey);
			if(pools.containsKey(accountKey)){
				//account is exist.
				if(pools.get(accountKey).getSession().getId()==session.getId()){
				    //update status
					boolean isOff=AVConnection.Status.OFFLINE.getValue().equals(pools.get(accountKey).getStatus());
					if(isOff){
						pools.put(accountKey, anthoer);
					}
				}else{
					//this is same account but not same connect.
					//maybe mutiple client use the same account to connect the socket server.
					pools.remove(accountKey);//remove old
					pools.put(accountKey, anthoer);
				}
			}else{
				//account is not exist.
				//add session(connect of socket) in pool.
				pools.put(accountKey, anthoer);
			}
		}
		
	}
	@Override
	public AVConnection findConnect(String accountKey) {
		return pools.get(accountKey);
	}

}
