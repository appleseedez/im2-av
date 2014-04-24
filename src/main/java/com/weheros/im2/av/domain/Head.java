/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.domain;

/**
 * @ClassName: Head
 * @author Yang
 * @date 2014年4月8日 下午2:17:18
 */
public class Head {
	
	private String sessionToken;
	//see <code>SignalType</code>
    private Integer signalType;
    // 0:normal,-1:abnormal
    private Integer status;
    
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public Integer getSignalType() {
		return signalType;
	}
	public void setSignalType(Integer signalType) {
		this.signalType = signalType;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
    
}
