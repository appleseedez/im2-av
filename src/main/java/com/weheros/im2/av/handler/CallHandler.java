/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.handler;

import com.weheros.im2.av.domain.Head;
import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.domain.SignalType;
import com.weheros.im2.av.request.StartCalling;
import com.weheros.im2.av.response.FAResponse;
import com.weheros.im2.av.response.StartCallingRes;
import com.weheros.platform.utils.ToJson;

/**
 * @ClassName: CallHandler
 * @author Administrator
 * @date 2014年4月23日 下午7:09:43
 */
public class CallHandler implements ISignalHandler {

	/*
	 * @param signal
	 * @return
	 * @see com.weheros.im2.av.handler.ISignalHandler#handle(com.weheros.im2.av.domain.Signal)
	 */

	@Override
	public Signal handle(Signal signal) {
		
		StartCalling calling=(StartCalling) ToJson.toObject(ToJson.toJson(signal.getBody()),StartCalling.class);
				
		StartCallingRes respone=new StartCallingRes();
		respone.setMyAccount(calling.getMyAccount());
		respone.setPeerAccount(calling.getPeerAccount());
		// TODO: query the sessionID and relay ip and port.
		respone.setSessionID(202);
		
		//create the response for this request.
		FAResponse fares=new FAResponse();		
		Head head=signal.getHead();
		head.setSignalType(SignalType.START_CALL_RES);		
		fares.setHead(head);
		fares.setBody(respone);
		
		return fares;
	}

}
