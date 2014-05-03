/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket;

import java.nio.charset.Charset;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineEncoder;

/**
 * @ClassName: AvProtocolCodecFactory
 * @author Administrator
 * @date 2014年5月3日 下午11:23:37
 */
public class AvProtocolCodecFactory implements ProtocolCodecFactory {
	private ProtocolEncoder encoder;
    private ProtocolDecoder decoder;

	public AvProtocolCodecFactory(ProtocolEncoder encoder,
			ProtocolDecoder decoder) {
		super();
		this.encoder = encoder==null? new TextLineEncoder(Charset.forName("UTF-8"), LineDelimiter.UNIX):encoder;
		this.decoder = decoder;
	}

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

}
