package com.weheros.im2.av.parser;

import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.request.Call;
import com.weheros.im2.av.request.FARequest;
import com.weheros.platform.utils.ToJson;

/**
 * @author Administrator
 * @version 1.0
 * @created 28-??-2014 14:50:34
 */
public class ParserFactory {
    
	private static String parse(String content){
		//split the signal string and find the part,which is json.
		// TODO
		return content;
	}
	public static Signal convert(String contentSignal){
		String all_json=parse(contentSignal);		
		return (Signal) ToJson.toObject(all_json, FARequest.class);	
	}

}