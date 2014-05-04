/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.request;

import java.io.Serializable;

/**
 * @ClassName: Reforward
 * @author Administrator
 * @date 2014年5月4日 下午1:15:23
 */
public class Reforward implements Serializable {
	
	/**
	 * @Fields serialVersionUID 
	 */
	private static final long serialVersionUID = 637982323724049255L;
	private String peerAccount;
	private String myAccount;
	private Object data;
	public String getPeerAccount() {
		return peerAccount;
	}
	public void setPeerAccount(String peerAccount) {
		this.peerAccount = peerAccount;
	}
	public String getMyAccount() {
		return myAccount;
	}
	public void setMyAccount(String myAccount) {
		this.myAccount = myAccount;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
