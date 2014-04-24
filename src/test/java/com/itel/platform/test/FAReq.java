/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.itel.platform.test;

import java.io.Serializable;

/**
 * @ClassName: FAReq
 * @author Administrator
 * @date 2014年4月3日 下午10:07:24
 */
public abstract class FAReq {
     String token;
}

class FAItel extends FAReq implements Serializable{
	/**
	  * @Fields serialVersionUID 
	  */
		
	private static final long serialVersionUID = 8110037516470871288L;
	String code;
	public String getCode() {
		return code;
	}
	
}
