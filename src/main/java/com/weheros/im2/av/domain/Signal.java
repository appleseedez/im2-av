package com.weheros.im2.av.domain;


/**
 * Signal definition.
 * 
 * @author Yang
 * @version 1.0
 * @created 27-03-2014 12:11:10
 */
public abstract class Signal {
    protected Head head;
    
    protected Object body;

	
	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

}