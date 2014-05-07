/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.domain;

import java.util.HashMap;
import java.util.Map;

import com.weheros.im2.av.request.FARequest;
import com.weheros.im2.av.request.HeartBeat;
import com.weheros.im2.av.request.Login;
import com.weheros.im2.av.request.Reforward;
import com.weheros.im2.av.request.StartCalling;


/**
 * @ClassName: ProtocolService
 * @author Administrator
 * @date 2014年5月6日 下午4:40:06
 */
public class ProtocolService {
    private static Login[] users=new Login[]{new Login("10001","123456"),new Login("10002","123456"),new Login("10003","123456")};
	private static Map<String,Integer> pointers=new HashMap<String,Integer>();
    
	public static Signal buildRequestSignal(String account,int type){		
		return initializeRequest(account,type);
	}
    
    private static Signal initializeRequest(String account, int type) {
		FARequest request = new FARequest();

		request.setBody(buildBody(type));

		Head head = new Head();
		head.setSessionToken(SessionTokenService.generateSessionToken(account, "123456"));
		head.setSignalType(type);// signal type
		head.setStatus(0);
		head.setSeq(takeSequnce(account));
		request.setHead(head);

		return request;
	}

	public static Signal buildRequestSignal(int type){
	      //use 10001 account as default.
		  return initializeRequest(users[0].getAccount(),type);
	}
    
    private static Object buildBody(int type) {
		if(SignalType.LOGIN_REQ==type){
			Login account=new Login();
			account.setAccount(users[0].getAccount());
			account.setPassword(users[0].getPassword());
			return account;
			  
		}else if(SignalType.START_CALL_REQ==type){
			StartCalling calling=new StartCalling();
			calling.setMyAccount(users[0].getAccount());
			calling.setPeerAccount(users[1].getAccount());
			return calling;
		}else if(SignalType.CALL==type){
            /*
		    {
		      "head":{
		        ...,
		        "signalType":401 // this indicate that the req or res is a relay signal. server should send data field to the peerAccount
		      },
		      "body":{
		        "nego":{"peerAccount":"appleseedez", "peerSessionID":112, "peerInterIP":"10.0.0.1", "peerInterPort":1234, "peerLocalIP":"10.0.0.2", "peerLocalPort":3425, "myAccount":"liuyang", "mySessionID":113,"bizType":1024},
		        "peerAccount":"liuyang",
		        "myAccount":"appleseedez"
		      }
		    }*/
			Reforward forward=new Reforward();
			forward.setMyAccount(users[0].getAccount());
			forward.setPeerAccount(users[1].getAccount());
			String dataJson="{\"peerAccount\":\"10001\", \"peerSessionID\":112, \"peerInterIP\":\"10.0.0.1\", \"peerInterPort\":1234, \"peerLocalIP\":\"10.0.0.2\", \"peerLocalPort\":3425, \"myAccount\":\"10002\", \"mySessionID\":113,\"bizType\":1024}";
			forward.setNego(dataJson);
			return forward;
		}
		return new HeartBeat();
	}
    
	private static Integer takeSequnce(String account) {
    	
    	if(pointers.containsValue(account)){
    		if(null== pointers.get(account)){
    			pointers.put(account, 1);
    			return 1;
    		}else{
    			int seq=pointers.get(account)+1;
    			pointers.put(account, seq);
    		return seq;
    		}
    	}else{
    		//
    		pointers.put(account, 1);
    		return 1;
    	}
    	
	}
	
}
