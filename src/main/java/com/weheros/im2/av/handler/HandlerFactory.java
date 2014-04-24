package com.weheros.im2.av.handler;

import java.util.HashMap;
import java.util.Map;

import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.domain.SignalType;

/**
 * Simple factory for ISignalHandler
 * @author Yang
 * @version 1.0
 * @created 27-03-2014 12:11:09
 */
public class HandlerFactory {
	private static final Map<Integer,ISignalHandler> handlers=new HashMap<Integer,ISignalHandler>();
	static{
		handlers.put(SignalType.LOGIN_REQ , new LoginHandler());
		handlers.put(SignalType.START_CALL_REQ , new CallHandler());
		
		//forward signal
		handlers.put(SignalType.END_SESSION , new ReforwardHandler());
		handlers.put(SignalType.ANSWER , new ReforwardHandler());
		handlers.put(SignalType.CALL , new ReforwardHandler());
		
		handlers.put(SignalType.LOGOUT_REQ , new LogoutHandler());
		handlers.put(SignalType.HEART_BEAT , new HeartBeatHandler());
	}
	public static ISignalHandler getInstance(Signal signal){
		
		int signalType=signal.getHead().getSignalType();
  
		return handlers.get(signalType);
	}

}