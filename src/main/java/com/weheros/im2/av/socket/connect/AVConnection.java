/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket.connect;

import org.apache.mina.core.session.IoSession;

/**
 * @ClassName: AVConnection
 * @author Administrator
 * @date 2014年5月4日 下午1:04:44
 */
public class AVConnection{
	private IoSession session;
	private String account;
	//status of client
	//online,offline
	private String status;
	enum Status{
		ONLINE("online"),
		OFFLINE("offline");
		
		private String value;
	
		Status(String value){
			this.value=value;
		}
		public String getValue() {
			return value;
		}
		
	}
	public AVConnection(IoSession session, String account) {
		super();
		this.session = session;
		this.account = account;
		this.status=Status.ONLINE.getValue();
	}

	@Override
	public boolean equals(Object obj) {
	    if (obj == null) {
	        return false;
	    }
	    if (getClass() != obj.getClass()) {
	        return false;
	    }
	    final AVConnection other = (AVConnection) obj;
	    if (!this.account.equals(other.account)) {
	        return false;
	    }
	   
	    return true;
	}

	@Override
	public int hashCode() {
	    int hash = 3;
	    hash = 53 * hash + (this.account != null ? this.account.hashCode() : 0);	  
	    return hash;
	}
	public IoSession getSession() {
		return session;
	}
	public String getAccount() {
		return account;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}