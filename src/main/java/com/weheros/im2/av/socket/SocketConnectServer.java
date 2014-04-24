package com.weheros.im2.av.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * @author Administrator
 * @version 1.0
 * @created 27-??-2014 12:11:10
 */
public class SocketConnectServer {
	
	protected static final Logger log = Logger.getLogger(SocketConnectServer.class);
	private final static int PORT = 9000;

	private SocketConnectServer() {

	}

	public static void main(String[] arr) {
		IoAcceptor acceptor = new NioSocketAcceptor();

		acceptor.getFilterChain().addLast("logger", new LoggingFilter());
		acceptor.getFilterChain().addLast("codec",	new ProtocolCodecFilter(new TextLineCodecFactory(Charset
						.forName("UTF-8"))));

		acceptor.setHandler(new AVSignalhandler());
		acceptor.getSessionConfig().setReadBufferSize(2048);
		acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
		try {
			acceptor.bind(new InetSocketAddress(PORT));
		} catch (IOException e) {
			log.error("========================socket server can not start, would exit!===========================", e);
			System.exit(-1);
		}
		log.info("===========================socket server starts success!!=========================");
        
	}

}