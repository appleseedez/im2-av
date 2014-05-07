/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @ClassName: TCPClient
 * @author Administrator
 * @date 2014年5月4日 上午12:21:56
 */
public class TCPClient {
	public static void main(String argv[]) throws Exception {
	       
	       
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        //115.29.145.142
        Socket clientSocket = new Socket("localhost", 9100);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
       
        String req_call="{\"head\":{\"sessionToken\":\"10001____123456\",\"signalType\":2,\"status\":0},\"body\":{\"peerAccount\":\"liuyang\",\"myAccount\":\"appleseedez\"}}";
      
        short length=Short.valueOf(req_call.length()+"");
        System.out.println("---------------------length to server---------------"+length);
        outToServer.writeShort(length);
        outToServer.writeBytes(req_call);
        //
        readFromInputStream2(clientSocket.getInputStream());
        
              
        clientSocket.close();
    }
	
	
	private static void readFromInputStream2(InputStream inputStream) throws IOException {
		 DataInputStream dis = new DataInputStream(inputStream);
		 
		  int numOfJson = dis.readUnsignedShort();
	 	  System.out.println("---------------------client:length of content---------------"+ numOfJson);
		 
	
       byte[] arr=new byte[2];
       int flag=0;
       String content="";
        while((flag = dis.read(arr)) !=-1){
       	 System.out.println("---------------------client: 2 byte content of backjson---------------"+ new String(arr));
       	 content+=new String(arr);        	 
       	 //System.out.println("---------------------client: this is flag---------------"+ flag);
       	 if(content.length()==numOfJson){
       		 //it is over 
       		 break;
       	   }
        }
   
       System.out.println("---------------------server:maybe content of backjson---------------"+ content);
		
	}
	
}
