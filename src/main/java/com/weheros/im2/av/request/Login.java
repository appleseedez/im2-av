/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.request;

import java.io.Serializable;

/**
 * @ClassName: Login
 * @author Yang
 * @date 2014年4月23日 下午5:37:42
 */
public class Login implements Serializable {
	
	/**
	  * @Fields serialVersionUID 
	  */
		
	private static final long serialVersionUID = -2574055897480518390L;
	private String account;
	private String password;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
