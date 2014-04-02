package com.weheros.im2.av.handler;

import com.weheros.im2.av.domain.HeartBeat;
import com.weheros.im2.av.domain.Login;
import com.weheros.im2.av.domain.Signal;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-??-2014 12:11:09
 */
public class HandlerFactory {

	public static ISignalHandler getInstance(Signal signal){
		ISignalHandler handler=null;
		
		if(signal instanceof Login ){
			handler=new LoginHandler();
		}
		if(signal instanceof HeartBeat){
			handler=new HeartBeatHandler();
		}
		return handler;
	}

}