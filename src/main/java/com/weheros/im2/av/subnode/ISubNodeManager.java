/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.subnode;

/**
 * @ClassName: ISubNodeManager
 * @author Yang
 * @date 2014年5月7日 下午10:38:20
 */
public interface ISubNodeManager {
	/**
	  * Select the realy server to peer by performance.
	  * @return 
	  * SubNode
	 */
	public SubNode selectRelayServer(); 

}
