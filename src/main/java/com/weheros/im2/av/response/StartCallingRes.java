/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */

package com.weheros.im2.av.response;

/**
 * @ClassName: StartCallingRes
 * @author Administrator
 * @date 2014年4月23日 下午7:38:57
 */
public class StartCallingRes {
	private String myAccount;
	private String peerAccount;
	private int sessionID;
	private String relayIP;
	private int relayPort;

	public String getMyAccount() {
		return myAccount;
	}

	public void setMyAccount(String myAccount) {
		this.myAccount = myAccount;
	}

	public String getPeerAccount() {
		return peerAccount;
	}

	public void setPeerAccount(String peerAccount) {
		this.peerAccount = peerAccount;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}

	public String getRelayIP() {
		return relayIP;
	}

	public void setRelayIP(String relayIP) {
		this.relayIP = relayIP;
	}

	public int getRelayPort() {
		return relayPort;
	}

	public void setRelayPort(int relayPort) {
		this.relayPort = relayPort;
	}

}
