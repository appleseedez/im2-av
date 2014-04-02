package com.itel.platform.test;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;


/**
 * 继承本测试方法，测试数据保存入数据库，不会删除。
 * @author l90003709
 *
 */
//@ContextConfiguration(locations = { "/applicationContext.xml","/applicationContext-aop.xml" })
@ContextConfiguration(locations = { "classpath*:*/applicationContext*.xml" })
public abstract class GenericJunitDataInDBTest extends AbstractJUnit4SpringContextTests{
	
}
