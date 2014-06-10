/**
 * Copyright HZCW (He Zhong Chuang Wei) Technologies Co.,Ltd. 2013-2015. All rights reserved.
 */
	
package com.weheros.im2.av.subnode;

import com.weheros.im2.av.infrastructure.configure.PropertiesService;

/**
 * @ClassName: RelayServerService
 * @author Administrator
 * @date 2014年5月7日 下午10:34:17
 */
public class SubNodeManager extends AbstractSubNodeManager {


	@Override
	SubNode chooseSuitableRealyServer(SubNode[] relayServers) {
		// TODO: Should choose one relay server by performance sort.
		// Any algorithm should be taken.
		// Now is only return zero index of the SubNode array.
		return relayServers[0];
	}

	@Override
	SubNode[] loadRelayServers() {
		//TODO:
		//Should select realy servers from Master of IM2.
		//Or select relay serveers from redis's cache data.
		
		String relayServers=PropertiesService.takeValueOfKey("av.relayServers");
		String[] servers=null;
		if(relayServers.indexOf(",")!=-1){
			servers=relayServers.split(",");
		}else
			servers=new String[]{relayServers};
		//
		SubNode[] nodes=new SubNode[servers.length];
		int index=0;
		for(String iports:servers){
			String[] arr=iports.split(":");//should has : char.
			nodes[index]=new SubNode(arr[0],Integer.valueOf(arr[1]));//ip and port
			index++;
		}
		return nodes;
	}
	
	

}
