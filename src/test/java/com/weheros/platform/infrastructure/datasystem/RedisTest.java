/**
 * Copyright (c) 2013-2014 HZCW Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.infrastructure.datasystem;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;

/**
 * @ClassName: RedisTest
 * @author Administrator
 * @date 2014年3月24日 下午5:20:51
 */
public class RedisTest {
      
	@Test
	public void testRedis(){
		Jedis jedis = new Jedis("115.29.145.142",6379);
		jedis.set("fookey", "bar");
		String value = jedis.get("fookey");
		
		Assert.assertTrue(value.equals("bar"));
		
	}
	@Test
	public void testPool(){
		JedisPool pool = new JedisPool("115.29.145.142",6379);
		Jedis jedis = pool.getResource();
		try {
		  /// ... do stuff here ... for example
		
		  jedis.zadd("sose", 0, "car"); 
		  jedis.zadd("sose", 0, "bike"); 
		  Set<String> valueset = jedis.zrange("sose", 0, -1);
		  Iterator<String> it=valueset.iterator();
		  while(it.hasNext()){
			  
			  System.out.println("----------------this is the value-------------------"+it.next());
		  }
		  
		} catch (JedisConnectionException e) {
		    // returnBrokenResource when the state of the object is unrecoverable
		    if (null != jedis) {
		        pool.returnBrokenResource(jedis);
		        jedis = null;
		    }
		} finally {
		  /// ... it's important to return the Jedis instance to the pool once you've finished using it
		  if (null != jedis)
		    pool.returnResource(jedis);
		}
		/// ... when closing your application:
		pool.destroy();
	}
}
