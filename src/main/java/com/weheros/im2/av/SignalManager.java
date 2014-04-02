package com.weheros.im2.av;

import org.apache.mina.core.session.IoSession;

import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.handler.HandlerFactory;
import com.weheros.im2.av.handler.ISignalHandler;
import com.weheros.im2.av.parser.ParserFactory;
import com.weheros.platform.security.Secrete;

/**
 * @author Yang
 * @version 1.0
 * @created 27-??-2014 12:11:10
 */
public class SignalManager{
   
	public static void handleSignal(IoSession session, String rawSignal) {
		
		// decrypt
		String contentSignal=Secrete.decrypt(rawSignal);
		// get json string from raw string
		// convert the json string to Signal object.
		Signal signal=ParserFactory.convert(rawSignal);
	    //process 
		ISignalHandler handler=HandlerFactory.getInstance(signal);
		String backJson=handler.handle(signal);
		//response to the remote peer
		//write back to client.
		session.write(backJson);
		
	}



}