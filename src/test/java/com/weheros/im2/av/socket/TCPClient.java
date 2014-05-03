/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @ClassName: TCPClient
 * @author Administrator
 * @date 2014年5月4日 上午12:21:56
 */
public class TCPClient {
	public static void main(String argv[]) throws Exception {
        String sentence;
        String modifiedSentence;
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 9100);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        
        String req_call="{\"head\":{\"sessionToken\":\"10001____123456\",\"signalType\":2,\"status\":0},\"body\":{\"peerAccount\":\"liuyang\",\"myAccount\":\"appleseedez\"}}";
        //sentence = inFromUser.readLine();
        short length=Short.valueOf(req_call.length()+"");
        outToServer.writeShort(length);
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
}
