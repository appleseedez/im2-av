/**
 * Copyright (c) 2013-2014 HZCW Technology Inc,All Rights Reserved.
 */
	
package com.weheros.im2.av.handler;

import com.weheros.im2.av.domain.Signal;
import com.weheros.im2.av.response.NotNeedResponse;
import com.weheros.platform.log.LogService;

/**
 * @ClassName: HeartBeatHandler
 * @author Yang
 * @date 2014年3月28日 下午9:27:33
 */
public class HeartBeatHandler implements ISignalHandler {

	@Override
	public Signal handle(Signal signal) {
		LogService.debug(HeartBeatHandler.class, "-This is HeartBeatHandler which is no response.-");
	
		return new NotNeedResponse();
		
		
	}

	

}
