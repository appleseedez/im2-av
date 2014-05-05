/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.socket.codec;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import com.weheros.im2.av.socket.SocketConnectServer;

/**
 * @ClassName: AVPrefixedStringEncoder
 * @author Administrator
 * @date 2014年5月4日 下午11:58:06
 */
public class AVPrefixedStringEncoder extends ProtocolEncoderAdapter {
	protected static final Logger LOG = Logger.getLogger(AVPrefixedStringEncoder.class);
	
	 private final Charset charset;
	public AVPrefixedStringEncoder(Charset charset) {
		this.charset=charset;
	}

	@Override
	public void encode(IoSession session, Object message,
			ProtocolEncoderOutput out) throws Exception {
		LOG.info("-------before encode-------" + message.toString());
		
		String value = (String) message;
		IoBuffer buffer = IoBuffer.allocate(value.length()).setAutoExpand(true);
		short length = Short.valueOf(value.length() + "");
		buffer.putShort(length);
		buffer.putString(message.toString(), charset.newEncoder());

		buffer.flip();
		out.write(buffer);
	}

}
