/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.handler;

import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.response.NotNeedResponse;

/**
 * @ClassName: ReforwardHandler
 * @author Yang
 * @date 2014年4月23日 下午7:11:27
 */
public class ReforwardHandler implements ISignalHandler {

	/*
	 * @param signal
	 * @return
	 * @see com.weheros.im2.av.handler.ISignalHandler#handle(com.weheros.im2.av.domain.Signal)
	 */

	@Override
	public Signal handle(Signal signal) {
		// TODO:forward the signal to the peer client.
		// find the connection and throw this signal to the peer client without any modify.
		
		
		return new NotNeedResponse();
	}

}
