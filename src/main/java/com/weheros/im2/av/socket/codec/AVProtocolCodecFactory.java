/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket.codec;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.BufferDataException;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.prefixedstring.PrefixedStringDecoder;

/**
 * @ClassName: AVProtocolCodecFactory
 * @author Administrator
 * @date 2014年5月4日 下午11:52:53
 */
public class AVProtocolCodecFactory implements ProtocolCodecFactory {
	
	 private final PrefixedStringDecoder decoder;
	 private final AVPrefixedStringEncoder encoder;
	 
	  public AVProtocolCodecFactory(Charset charset) {
	        encoder = new AVPrefixedStringEncoder(charset);
	        decoder = new PrefixedStringDecoder(charset);
	    }


	/*
	 * @param session
	 * @return
	 * @throws Exception
	 * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getEncoder(org.apache.mina.core.session.IoSession)
	 */

	@Override
	public ProtocolEncoder getEncoder(IoSession session) throws Exception {
		
		return encoder;
	}

	/*
	 * @param session
	 * @return
	 * @throws Exception
	 * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getDecoder(org.apache.mina.core.session.IoSession)
	 */

	@Override
	public ProtocolDecoder getDecoder(IoSession session) throws Exception {
		
		return decoder;
	}
	 /**
     * Sets the maximum allowed value specified as data length in the decoded data
     * <p>
     * Useful for preventing an OutOfMemory attack by the peer.
     * The decoder will throw a {@link BufferDataException} when data length
     * specified in the incoming data is greater than maxDataLength
     * The default value is {@link PrefixedStringDecoder#DEFAULT_MAX_DATA_LENGTH}.
     *
     * This method does the same job as {@link PrefixedStringDecoder#setMaxDataLength(int)}.
     * </p>
     *
     * @param maxDataLength maximum allowed value specified as data length in the incoming data
     */
    public void setDecoderMaxDataLength(int maxDataLength) {
        decoder.setMaxDataLength(maxDataLength);
    }

    /**
     * Sets the length of the prefix used by the decoder
     *
     * @param prefixLength the length of the length prefix (1, 2, or 4)
     */
    public void setDecoderPrefixLength(int prefixLength) {
        decoder.setPrefixLength(prefixLength);
    }

}
