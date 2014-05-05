/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.Charset;

/**
 * @ClassName: TCPClient
 * @author Administrator
 * @date 2014年5月4日 上午12:21:56
 */
public class TCPClient {
	
	public static void testforAllString()throws Exception{
		    String modifiedSentence;
	        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

	        Socket clientSocket = new Socket("115.29.145.142", 9100);
	        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
	        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        
	        String req_call="128{\"head\":{\"sessionToken\":\"10001____123456\",\"signalType\":2,\"status\":0},\"body\":{\"peerAccount\":\"liuyang\",\"myAccount\":\"appleseedez\"}}";
	        //sentence = inFromUser.readLine();
	        
	        short length=Short.valueOf(req_call.length()+"");
	        System.out.println("---------------------length to server---------------"+length);
	        //outToServer.writeShort(length);
	        outToServer.writeBytes(req_call);
	        
	        modifiedSentence = inFromServer.readLine();
	        String line="";
	        while ((line = inFromServer.readLine()) != null)
	        {
	        	modifiedSentence+=line;
	        }
	        System.out.println("---------------------back from server---------------"+modifiedSentence);
	        
	        clientSocket.close();
	}
	public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence="";
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        //115.29.145.142
        Socket clientSocket = new Socket("localhost", 9100);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(),Charset.forName("UTF-8")));
        
        String req_call="{\"head\":{\"sessionToken\":\"10001____123456\",\"signalType\":2,\"status\":0},\"body\":{\"peerAccount\":\"liuyang\",\"myAccount\":\"appleseedez\"}}";
        //sentence = inFromUser.readLine();
        
        short length=Short.valueOf(req_call.length()+"");
        System.out.println("---------------------length to server---------------"+length);
        outToServer.writeShort(length);
        outToServer.writeBytes(req_call);
        
        //modifiedSentence = inFromServer.ready();
        //String line="";
        char[] onearr=new char[1];
        int flag=0;
       /* for(;;){
	        if (inFromServer.ready())
	        {   
	        	char[] maybenum=new char[2];
	        	 inFromServer.read(maybenum);
	        	
	        	int maybelength=Integer.valueOf(new String(maybenum));
	        	 System.out.println("---------------------maybe length of backjson---------------"+maybelength);
	        	 char[] content=new char[maybelength];
	        	 inFromServer.read(content,2,maybelength);
	        	 
	        	 modifiedSentence=new String(content);
	        	        
	        	 
	        	 break;
	        }
	        Thread.sleep(2000);
        }*/
        for(;;){
	        if(inFromServer.read(onearr)!=-1){
	        
	        	 modifiedSentence+=new String(onearr);
	             System.out.println("---------------------maybe content of backjson---------------"+modifiedSentence);
	        }else{
	        	break;
	        }
	        	
        }
        System.out.println("---------------------back from server---------------"+modifiedSentence);
        
              
        clientSocket.close();
    }
	
	
}
