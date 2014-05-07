/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.weheros.im2.av.domain.ProtocolService;
import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.domain.SignalType;
import com.weheros.platform.log.LogService;
import com.weheros.platform.utils.ToJson;

/**
 * @ClassName: ReforwardHandlerTest
 * @author Administrator
 * @date 2014年5月6日 下午11:07:08
 */
public class ReforwardHandlerTest {
	Socket client_10001 = null;
	DataOutputStream dos_10001 = null;
	DataInputStream dis_10001=null;
	
	Socket client_10002 = null;
	DataOutputStream dos_10002 = null;
	DataInputStream dis_10002=null;
	
	@Before
	public void init() throws UnknownHostException, IOException {
		String server="localhost";
		//        
		client_10001 = new Socket(server, 9100);
		dos_10001 = new DataOutputStream(client_10001.getOutputStream());
		dis_10001 = new DataInputStream(client_10001.getInputStream());
		LogService.info(ReforwardHandlerTest.class, "-----client_10001 is connected server "+server+"--");
        //
		client_10002 = new Socket(server, 9100);
		dos_10002 = new DataOutputStream(client_10002.getOutputStream());
		dis_10002 = new DataInputStream(client_10002.getInputStream());
		LogService.info(ReforwardHandlerTest.class, "-----client_10002 is connected server "+server+"--");
		
		// send heartbeat to server
		// register to server first time.
		Signal heartbeat_10001=ProtocolService.buildRequestSignal("10001",SignalType.HEART_BEAT);
		sendSignalToServer(heartbeat_10001,dos_10001);
		LogService.info(ReforwardHandlerTest.class, "-----client_10001 is registered to server "+server+"--");
		
		Signal heartbeat_10002=ProtocolService.buildRequestSignal("10002",SignalType.HEART_BEAT);
		sendSignalToServer(heartbeat_10002,dos_10002);
		LogService.info(ReforwardHandlerTest.class, "-----client_10002 is registered to server "+server+"--");
	}
	@After
	public void destory(){
		
			try {
				if(dos_10001!=null){
					dos_10001.close();
				}
				
				if(dis_10001!=null){
					dis_10001.close();
				}
				
				if(client_10001!=null){
					client_10001.close();
				}
				LogService.info(ReforwardHandlerTest.class, "-----destory client_10001 connenction--");
			} catch (IOException e) {
				LogService.error(CallHandlerTest.class, "close with error",e);
				e.printStackTrace();
			}
			//
			try {
				if(dos_10002!=null){
					dos_10002.close();
				}
				
				if(dis_10002!=null){
					dis_10002.close();
				}
				
				if(client_10002!=null){
					client_10002.close();
				}
				LogService.info(ReforwardHandlerTest.class, "-----destory client_10002 connenction--");
				
			} catch (IOException e) {
				LogService.error(CallHandlerTest.class, "close with error",e);
				e.printStackTrace();
			}
		
		
	}
	//the common method to write json to server 
	protected void sendSignalToServer(Signal signal,DataOutputStream dos) throws IOException {
		// write to server
		String req = ToJson.toJson(signal);
		short length = Short.valueOf(req.length() + "");
		System.out.println("---------------------length to server---------------"+ length);

		dos.writeShort(length);
		dos.writeBytes(req);	
	
	}
	//the common method to read from server
	protected void readReturnFromServer(DataInputStream dis) throws IOException {
		int numOfJson = dis.readUnsignedShort();
		System.out.println("---------------------length of server's return json)---------------"+ numOfJson);
        
		byte[] arr = new byte[1];
		int flag = 0;
		String content = "";
		while ((flag = dis.read(arr)) != -1) {
			//System.out.println("---------------------client: 2 byte content of backjson---------------"	+ new String(arr));
			content += new String(arr);
		
			if (content.length() == numOfJson) {
				// it is over
				break;
			}
		}

		System.out.println("---------------------content of server's return json---------------"+ content);

	}
	
	
	@Test
	public void testRefowardCall() throws IOException{
		// 10001 -> 10002
		// call
		Signal signal = ProtocolService.buildRequestSignal(SignalType.CALL);
		sendSignalToServer(signal,dos_10001);
		// server return nothing to 10001
		
		// 10002 should recieve from server.
		LogService.info(ReforwardHandlerTest.class, "-----client_10002 should get the return json from server--");
		readReturnFromServer(dis_10002);
		
		
	}

}
