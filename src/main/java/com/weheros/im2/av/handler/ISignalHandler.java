package com.weheros.im2.av.handler;

import com.weheros.im2.av.domain.Signal;

/**
 * interface of signal handing.
 * 
 * @author Yang
 * @version 1.0
 * @created 27-03-2014 12:11:09
 */
public interface ISignalHandler {
	/**
	 * process the signal transfer by client.
	 * <p />
	 * The input is signal and response is also signal.
	 * <p>They have the same data structure.
	 * @param signal
	 * @return response
	 */
	public Signal handle(Signal signal);

}