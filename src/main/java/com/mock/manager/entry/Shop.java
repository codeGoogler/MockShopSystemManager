package com.mock.manager.entry;

import java.util.Date;
import java.util.List;

public class Shop {

	private int shopId;
//	private Long ownerId;
//	private Long shopCategoryId;
	private String shopName;
	private String shopDesc;
	private String shopAddr;
	private String phone;
	private String shopImg;
	private Double longitude;
	private Double latitude;
	private Integer priority;
	private Date createTime;
	private Date lastModifyTime;
	private Integer enableStatus;
	// 超级管理员对店家的提醒
	private String advice;

//	private List<ShopAuthMap> staffList;
	private Area area;
	private PersonInfo owner;
	private ShopCategory shopCategory;
//	private ShopCategory parentCategory;

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}


//	public Long getShopCategoryId() {
//		return shopCategoryId;
//	}
//
//	public void setShopCategoryId(Long shopCategoryId) {
//		this.shopCategoryId = shopCategoryId;
//	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopDesc() {
		return shopDesc;
	}

	public void setShopDesc(String shopDesc) {
		this.shopDesc = shopDesc;
	}

	public String getShopAddr() {
		return shopAddr;
	}

	public void setShopAddr(String shopAddr) {
		this.shopAddr = shopAddr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}


	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}



	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public ShopCategory getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(ShopCategory shopCategory) {
		this.shopCategory = shopCategory;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}


	public PersonInfo getOwner() {
		return owner;
	}

	public void setOwner(PersonInfo owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Shop{" +
				"shopId=" + shopId +
				", shopName='" + shopName + '\'' +
				", shopDesc='" + shopDesc + '\'' +
				", shopAddr='" + shopAddr + '\'' +
				", phone='" + phone + '\'' +
				", shopImg='" + shopImg + '\'' +
				", longitude=" + longitude +
				", latitude=" + latitude +
				", priority=" + priority +
				", createTime=" + createTime +
				", lastModifyTime=" + lastModifyTime +
				", enableStatus=" + enableStatus +
				", advice='" + advice + '\'' +
				", area=" + area +
				", owner=" + owner +
				", shopCategory=" + shopCategory +
				'}';
	}
}
