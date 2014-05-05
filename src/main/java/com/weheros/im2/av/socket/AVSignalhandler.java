package com.weheros.im2.av.socket;

import java.util.Date;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.weheros.im2.av.SignalManager;
import com.weheros.platform.utils.ToJson;

/**
 * Connections handler.
 * @author Yang
 * @version 1.0
 * @created 27-03-2014 12:11:09
 */
public class AVSignalhandler extends IoHandlerAdapter {
	  private static final Logger LOGGER = LoggerFactory.getLogger(AVSignalhandler.class);

	 
	    public void sessionOpened(IoSession session) throws Exception {
	        // Empty handler
	    }

	    public void sessionClosed(IoSession session) throws Exception {
	        // Empty handler
	    }

	    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
	        // Empty handler
	    }

	    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
	        if (LOGGER.isWarnEnabled()) {
	            LOGGER.warn("EXCEPTION, please implement " + getClass().getName()
	                    + ".exceptionCaught() for proper handling:", cause);
	        }
	        session.close(true);
	    }
        
	    private static String readedContent="";
	    private static int lengthOfConetent=0;
	    private static int readedLengthOfConetent=0;
	    public void messageReceived(IoSession session, Object message) throws Exception {
	       
	    	
	    /*	while(true){
	    		LOGGER.info("-------------receive the message-------------"+new Date()+"----"+ToJson.toJson(message));
	    		String current=message.toString();
	    		if(current.getBytes().length< 2){
	    			//no is possible
	    			//if this is true,IT IS HALT!
	    			LOGGER.error("-----the message from client is NOT ------------"+ToJson.toJson(message));
	    		}
	    		if(lengthOfConetent == 0){ //first read
	    		String maybeLengthOfJson=current.substring(0, 1);
	    		lengthOfConetent=Integer.valueOf(maybeLengthOfJson);//length of json	
	    		//maybe the whole json
	    		
	    		readedContent=readedContent+current.substring(2);
	    		readedLengthOfConetent+=current.substring(2).length();
	    		}else{

		    		readedContent=readedContent+current;
		    		readedLengthOfConetent+=current.length();
	    		}
	    		
	    		if(lengthOfConetent!=0 && readedLengthOfConetent==lengthOfConetent){
	    			break;
	    		}
	    		LOGGER.info("------------whole length of json----------"+lengthOfConetent+",--------current readed length is------ "+readedLengthOfConetent);
	    	}*/
	      
	    	//invoke the manager
	    	//LOGGER.info("-------------the whole receive json string is------------"+readedContent);
	    	LOGGER.info("-------------receive the message-------------"+new Date()+"----"+ToJson.toJson(message));
	    	String response=SignalManager.handleSignal(session,message.toString());
	    	if(response!=null&&!"".equals(response)){
	    	 
	    	   session.write(response);
	    	   
	    	   
	    	}
	    }

	 
}