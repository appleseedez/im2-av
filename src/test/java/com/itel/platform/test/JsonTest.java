package com.itel.platform.test;

import org.junit.Test;

import com.weheros.im2.av.domain.Head;
import com.weheros.im2.av.request.FARequest;
import com.weheros.im2.av.request.Login;
import com.weheros.platform.utils.ToJson;

public class JsonTest {
	
	@Test
	public void testa2(){
		
		FAItel one=new FAItel();
		one.code="rrr";
		System.out.println(ToJson.toJson(one));
	}
	
	@Test
	public void testsignal(){
		FARequest request=new FARequest();
		request.setHead(new Head());
		System.out.println(ToJson.toJson(request));
	}
	
	@Test
	public void testParseRequest(){
		Login login=new Login();
		login.setAccount("xiaodao100");
		login.setPassword("xhh2007");
		String json=ToJson.toJson(login);
				
		String allstr="{\"head\":{\"sessionToken\":\"aaa\",\"signalType\":0,\"status\":0},\"body\":"+json+"}";
		
		System.out.println("-----------all string is--------------"+allstr);
		FARequest req=(FARequest) ToJson.toObject(allstr, FARequest.class);		
		System.out.println(req.getBody());
		Login newone=(Login) ToJson.toObject(ToJson.toJson(req.getBody()),Login.class);
		newone.setAccount("new one");
		System.out.println("---------------newest json-----------"+newone.getAccount());
		
	}

}
