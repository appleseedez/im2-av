/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.response;

import com.weheros.im2.av.domain.Head;
import com.weheros.im2.av.domain.SignalType;

/**
 * @ClassName: NoResponse
 * @author Administrator
 * @date 2014年4月24日 上午11:52:30
 */
public class NotNeedResponse extends FAResponse {

	/**
	  * @Fields serialVersionUID 
	  */		
	private static final long serialVersionUID = -5971722965400220926L;
	public NotNeedResponse(){
		this.head=new Head();
		this.head.setSignalType(SignalType.NOT_NEED_RESPONSE);
	}

}
