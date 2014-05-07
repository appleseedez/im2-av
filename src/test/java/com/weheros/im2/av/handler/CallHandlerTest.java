/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */

package com.weheros.im2.av.handler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import com.weheros.im2.av.domain.ProtocolService;
import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.domain.SignalType;
import com.weheros.platform.log.LogService;
import com.weheros.platform.utils.ToJson;

/**
 * @ClassName: ReforwardHandlerTest
 * @author Administrator
 * @date 2014年5月6日 下午4:35:12
 */
public class CallHandlerTest {
	Socket clientSocket = null;
	DataOutputStream dos = null;
	DataInputStream dis=null;
	
	@Before
	public void init() throws UnknownHostException, IOException {
		//
        
		clientSocket = new Socket("localhost", 9100);
		dos = new DataOutputStream(clientSocket.getOutputStream());
		dis = new DataInputStream(clientSocket.getInputStream());

	}
	@After
	public void destory(){
		
			try {
				if(dos!=null){
				dos.close();
				}
				
				if(dis!=null){
					dis.close();
				}
				
				if(clientSocket!=null){
					clientSocket.close();
				}
			} catch (IOException e) {
				LogService.error(CallHandlerTest.class, "close with error",e);
				e.printStackTrace();
			}
		
		
	}
	
	 @Rule
	  public TestWatcher testWatcher = new TestWatcher() {
	    protected void failed(Throwable e, Description description) {
	     
	      LogService.error(CallHandlerTest.class,"" + description.getDisplayName() + " failed ",e);
	      super.failed(e, description);
	    }

	  };


	protected void readReturnFromServer()
			throws IOException {
		int numOfJson = dis.readUnsignedShort();
		System.out.println("---------------------client:length of content---------------"+ numOfJson);
        
		byte[] arr = new byte[1];
		int flag = 0;
		String content = "";
		while ((flag = dis.read(arr)) != -1) {
			System.out.println("---------------------client: 2 byte content of backjson---------------"	+ new String(arr));
			content += new String(arr);
		
			if (content.length() == numOfJson) {
				// it is over
				break;
			}
		}

		System.out.println("---------------------client:maybe content of backjson---------------"+ content);

	}

	protected void sendSignalToServer(Signal signal) throws IOException {
		// write to server
		String req = ToJson.toJson(signal);
		short length = Short.valueOf(req.length() + "");
		System.out.println("---------------------length to server---------------"+ length);

		dos.writeShort(length);
		dos.writeBytes(req);	
	
	}
    @Test
	public void testStartCallHandle() throws IOException {

		Signal signal = ProtocolService.buildRequestSignal(SignalType.START_CALL_REQ);

		sendSignalToServer(signal);
		readReturnFromServer();

	}
}
