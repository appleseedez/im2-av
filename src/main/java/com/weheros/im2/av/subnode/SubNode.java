/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.subnode;

/**
 * @ClassName: SubNode
 * @author Administrator
 * @date 2014年5月7日 下午10:40:41
 */
public class SubNode {
	private String ip;
	private int port;	
	private Performance performance;
    public SubNode(){
    	
    }
	public SubNode(String ip, int port) {
		super();
		this.ip = ip;
		this.port = port;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}
	

}
class Performance{
	
}
