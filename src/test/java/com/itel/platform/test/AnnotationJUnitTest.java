/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.itel.platform.test;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @ClassName: AnnotationJUnitTest
 * @Description: 测试基类，全部使用注解
 * @author Administrator
 * @date 2013年11月11日 下午1:52:41
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/community-servlet.xml","classpath*:/spring/applicationContextTest*.xml" })
public abstract class AnnotationJUnitTest {
	protected Logger log = Logger.getLogger(getClass()); 
	
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));
	

}
