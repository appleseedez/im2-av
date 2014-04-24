/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket.connect;

import org.apache.mina.core.session.IoSession;

/**
 * @ClassName: IRegistry
 * @author Yang
 * @date 2014年4月3日 下午6:06:50
 */
public interface IConnectManager {
      public int add(IoSession session);
      public void remove(IoSession session);
      
}
