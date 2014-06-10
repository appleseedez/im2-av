/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.subnode;


/**
 * Show the template implements of <code>ISubNodeManager</code>.
 * @ClassName: AbstractSubNodeManager
 * @author Yang
 * @date 2014年5月7日 下午11:02:33
 */
public abstract class AbstractSubNodeManager implements ISubNodeManager  {
	@Override
	public SubNode selectRelayServer() {
		
		SubNode[] relayServers=loadRelayServers();
		return chooseSuitableRealyServer(relayServers);
	}

	abstract SubNode[] loadRelayServers();
	abstract SubNode chooseSuitableRealyServer(SubNode[] relayServers) ;		

}
