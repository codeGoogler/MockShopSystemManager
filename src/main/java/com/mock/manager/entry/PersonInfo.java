package com.mock.manager.entry;

import java.util.Date;

public class PersonInfo {

	private Long userId;
	private String name;
	private Date birthday;
	private String gender;
	private String phone;
	private String email;
	private String profileImg;
	private Integer customerFlag;
	private Integer shopOwnerFlag;
	private Integer adminFlag;
	private Date createTime;
	private Date lastEditTime;
	private Integer enableStatus;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public Integer getCustomerFlag() {
		return customerFlag;
	}

	public void setCustomerFlag(Integer customerFlag) {
		this.customerFlag = customerFlag;
	}

	public Integer getShopOwnerFlag() {
		return shopOwnerFlag;
	}

	public void setShopOwnerFlag(Integer shopOwnerFlag) {
		this.shopOwnerFlag = shopOwnerFlag;
	}

	public Integer getAdminFlag() {
		return adminFlag;
	}

	public void setAdminFlag(Integer adminFlag) {
		this.adminFlag = adminFlag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

}
