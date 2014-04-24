package com.weheros.im2.av;


import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.domain.SignalType;
import com.weheros.im2.av.handler.HandlerFactory;
import com.weheros.im2.av.handler.ISignalHandler;
import com.weheros.im2.av.parser.ParserFactory;
import com.weheros.platform.security.Secrete;
import com.weheros.platform.utils.ToJson;

/**
 * @author Yang
 * @version 1.0
 * @created 27-03-2014 12:11:10
 */
public class SignalManager{
   
	public static String handleSignal(String rawSignal) {
		
		// decrypt,this is not implemented now.
		String contentSignal=Secrete.decrypt(rawSignal);
		// get json string from raw string
		// convert the json string to Signal object.
		Signal signal=ParserFactory.convert(contentSignal);
	    //process 
		ISignalHandler handler=HandlerFactory.getInstance(signal);
		Signal response=handler.handle(signal);
		//response to the remote peer
		//write back to client.
		String backJson=encapsulate(response);//ToJson.toJson(response);
		return backJson;
		
	}
    /**
     *  If there is no response,return empty string.
     *  <p>else,return the json of response.
      * @param response
      * @return String
     */
	private static String encapsulate(Signal response) {
		//Head of response can not be empty.
		boolean isNotNeedResponse=SignalType.NOT_NEED_RESPONSE==response.getHead().getSignalType();
		return isNotNeedResponse?"":ToJson.toJson(response);
	}



}