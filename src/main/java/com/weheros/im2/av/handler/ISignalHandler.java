package com.weheros.im2.av.handler;

import com.weheros.im2.av.domain.Signal;

/**
 * interface of signal handing.
 * @author Administrator
 * @version 1.0
 * @created 27-03-2014 12:11:09
 */
public interface ISignalHandler {
	/**
	 *  process the command transfer by client.	  
	 *  <p />
	 *  return back the result. 
	  * String
	 * @param signal 
	 */
	public String handle(Signal signal);

}