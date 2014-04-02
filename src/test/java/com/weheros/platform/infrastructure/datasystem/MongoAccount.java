/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */

package com.weheros.platform.infrastructure.datasystem;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName: Account
 * @Description: TODO
 * @author Administrator
 * @date 2013年10月30日 下午11:02:57
 * 
 */
@Document(collection = "accountColl")
public class MongoAccount {

	@Id
	private ObjectId id;
	private String name;
	private Integer year;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

}
