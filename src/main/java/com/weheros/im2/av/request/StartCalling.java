/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */

package com.weheros.im2.av.request;

import java.io.Serializable;

/**
 * @ClassName: StartCalling
 * @author Yang
 * @date 2014年4月23日 下午7:29:18
 */
public class StartCalling implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = -8330434206308959243L;
	private String peerAccount;
	private String myAccount;

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

}
