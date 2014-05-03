/*
* Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
*
*
*/
package com.weheros.im2.av.exception;

/**
 * @ClassName: JsonException
 * @author Administrator
 * @date 2014年3月28日 下午3:20:30
 */
public class JsonException extends RuntimeException {

	/**
	  * @Fields serialVersionUID 
	  */		
	private static final long serialVersionUID = -5603951811237491338L;

	public JsonException(String message) {
		super(message);
	}

	public JsonException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonException(Throwable cause) {
		super(cause);
	}
}
