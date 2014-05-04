/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket.connect;

import org.apache.mina.core.session.IoSession;

import com.weheros.im2.av.domain.Signal;

/**
 * @ClassName: IRegistry
 * @author Yang
 * @date 2014年4月3日 下午6:06:50
 */
public interface IConnectManager {
	  
      public void register(String account,IoSession session);
      public void remove(String account);
      /**
        * if this is the first time that client connect to server.
	    * record information of the connect session.        
        * @param session
        * @param signal 
        * void
       */
	  public void maintainConnection(IoSession session, Signal signal);
	  public AVConnection findConnect(String accountKey);
      
}
