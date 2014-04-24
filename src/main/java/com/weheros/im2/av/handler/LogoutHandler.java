/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.handler;

import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.response.NotNeedResponse;

/**
 * @ClassName: LogoutHandler
 * @author Administrator
 * @date 2014年4月23日 下午7:18:12
 */
public class LogoutHandler implements ISignalHandler {

	/*
	 * @param signal
	 * @return
	 * @see com.weheros.im2.av.handler.ISignalHandler#handle(com.weheros.im2.av.domain.Signal)
	 */

	@Override
	public Signal handle(Signal signal) {
		// TODO 
		// remove the connect from pool of this client.
		
		return new NotNeedResponse();
	}

}
