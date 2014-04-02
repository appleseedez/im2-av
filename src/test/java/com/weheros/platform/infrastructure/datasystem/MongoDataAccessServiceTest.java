/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.platform.infrastructure.datasystem;

import java.util.List;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.itel.platform.test.GenericJunitTestCase;

import com.weheros.platform.utils.ToJson;

/**
 * @ClassName: MongoDataAccessService

 * @author Administrator
 * @date 2013年10月30日 下午10:46:44
 *
 */

public class MongoDataAccessServiceTest extends GenericJunitTestCase {
	protected Logger log = Logger.getLogger(getClass());
	
	@Autowired
	@Qualifier("mongoDataAccessService")
	INoSQLDataAccess noSQLDataAccess;
	
	@Before
	public void init(){
			
		MongoContact mongoContact=new MongoContact();
		mongoContact.setHostUserId(1);		
		
		Contact contact=new Contact();		
		contact.setUserId(3);
		contact.setItel("1000002");
		contact.setAlias("tony");
		contact.setPhone("15899990001");
		contact.setPhoneSecret(true);
		mongoContact.setContact(contact);
		
		MongoContact mongoContact2=new MongoContact();
		mongoContact2.setHostUserId(1);
		
		Contact contact2=new Contact();		
		contact2.setUserId(2);
		
		contact2.setItel("1000001");
		contact2.setAlias("hack");
		contact2.setPhone("15899990000");
		contact2.setPhoneSecret(true);
		mongoContact2.setContact(contact2);
		
		noSQLDataAccess.getMongoOps().insert(mongoContact);
		noSQLDataAccess.getMongoOps().insert(mongoContact2);
	}
	@After
	public void destory(){
		List<MongoContact> all=this.noSQLDataAccess.getMongoOps().findAll(MongoContact.class);
		for(MongoContact one:all){
			this.noSQLDataAccess.getMongoOps().remove(one);
		}
	}

	@Test
	public void testContact(){
		//527124f4ae0c8fdfba2f9910	
		//15899990001,15899990000
		List<MongoContact> list=noSQLDataAccess.queryList(Query.query(Criteria.where("hostUserId").is(1).and("contact.phone").in(new Object[]{"15899990001","15899990000"})), MongoContact.class);
		for(MongoContact contact:list){
			log.debug("--------------contact from mongo-----------"+ToJson.toJson(contact));
		}
		Assert.assertSame(list.size(),2);
		
	}
	@Test
	public void testLikeQuery(){
		//can not support or in mongodb
		//.orOperator(Criteria.where("contact.phone")).regex(pattern)
		//Query.query(Criteria.where("alias").regex(pattern)
		Pattern pattern=Pattern.compile("5899");
		Query monquery=Query.query(Criteria.where("contact.phone").regex(pattern)).limit(20).skip(0);
		
		List<MongoContact> list=noSQLDataAccess.queryList(monquery, MongoContact.class);
		
		Assert.assertSame(list.size(),2);
	}
	

}
