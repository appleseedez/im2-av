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
        
	 
	    public void messageReceived(IoSession session, Object message) throws Exception {
	 	      
	    	//invoke the manager	    	
	    	LOGGER.info("-------------receive the message-------------"+new Date()+"----"+ToJson.toJson(message));
	    	String response=SignalManager.handleSignal(session,message.toString());
	    	if(response!=null&&!"".equals(response)){
	    	   LOGGER.info("------------wirte back to client------------"+response);
	    	   session.write(response);   	   
	    	   
	    	}
	    }

	 
}