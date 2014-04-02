package com.itel.platform.test;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * 请使用junit4注解方式。
 * 测试使用的基础代码 需要数据源以及SpringContent时请继承本类。
 * 如果不需要数据库源，直接使用<code>@Test</code>注解标识测试方法，参考 SimpleTest。
 * @author l00003709
 * 
 */

@ContextConfiguration(locations = { "classpath*:*/applicationContext*.xml","classpath*:/spring/application-security.xml" })
public class GenericJunitTestCase extends AbstractTransactionalJUnit4SpringContextTests{
	
	

}
