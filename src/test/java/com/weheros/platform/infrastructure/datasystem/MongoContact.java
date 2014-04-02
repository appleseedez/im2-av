/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */

package com.weheros.platform.infrastructure.datasystem;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName: MongoContact
 * @Description: 在mongodb中使用
 * @author Yang
 * @date 2013年11月21日 下午4:33:11
 */
@Document(collection = "contact")
public class MongoContact {
	@Id
	private ObjectId id;
	// 主人id
	private Integer hostUserId;
	
	private Contact contact;
	

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getHostUserId() {
		return hostUserId;
	}

	public void setHostUserId(Integer hostUserId) {
		this.hostUserId = hostUserId;
	}

}
