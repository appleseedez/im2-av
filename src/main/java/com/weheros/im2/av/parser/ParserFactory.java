package com.weheros.im2.av.parser;

import com.weheros.im2.av.domain.Login;
import com.weheros.im2.av.domain.Signal;
import com.weheros.platform.utils.ToJson;

/**
 * @author Administrator
 * @version 1.0
 * @created 28-??-2014 14:50:34
 */
public class ParserFactory {
    
	private static void parse(String content){
		//split the signal string and find the part,which is json.
		// TODO
		
	}
	public static Signal convert(String contentSignal){
		parse(contentSignal);
		//if it is json		
		// TODO
		return (Signal) ToJson.toObject(contentSignal, Login.class);	
	}

}