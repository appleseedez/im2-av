/**
 * Copyright (c) 2011-2013 iTel Technology Inc,All Rights Reserved.
 */

package com.weheros.platform.infrastructure.datasystem;



/**
 * @ClassName: Contact
 * @Description: the object return to the client. APP,website or other invokers.
 * @author Administrator
 * @date 2013年11月20日 上午11:45:41
 */
public class Contact {
	public static final String PICTURE_ADDRESS = "http://115.28.21.131:8000/";

	private Integer userId;
	private String itel;// itel号码
	private boolean phoneSecret;
	private String phone = "";
	private String alias = ""; // 别名
	private String nickname = "";
	private String photo_file_name = "";
	private String homePage = "";

	private String recommend = "";// 个性签名
	private String sex = "";// 性别 0：女；1：男
	private String birthday = "";// 生日
	private String area_code = "";// 地区编码
	private String mail = "";// 邮件
	private String qq_num = "";// qq号

	// 被添加人同意后，成为朋友
	private boolean isFriend;
	private boolean isBlack;

	public boolean getIsFriend() {
		return isFriend;
	}

	public void setFriend(boolean isFriend) {
		this.isFriend = isFriend;
	}

	public boolean getIsBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getItel() {
		return itel;
	}

	public void setItel(String itel) {
		this.itel = itel;
	}

	public boolean isPhoneSecret() {
		return phoneSecret;
	}

	public void setPhoneSecret(boolean phoneSecret) {
		this.phoneSecret = phoneSecret;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPhoto_file_name() {
		if (photo_file_name != null && !photo_file_name.equals("")) {
			return PICTURE_ADDRESS + photo_file_name;
		}
		return photo_file_name;
	}

	public void setPhoto_file_name(String photo_file_name) {
		this.photo_file_name = photo_file_name;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getQq_num() {
		return qq_num;
	}

	public void setQq_num(String qq_num) {
		this.qq_num = qq_num;
	}

}
