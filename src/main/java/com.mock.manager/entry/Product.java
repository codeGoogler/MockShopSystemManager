package com.mock.manager.entry;

import java.util.Date;
import java.util.List;

/**
 * 类功能描述：</br>
 * 每一个商品实体类信息
 * @author yuyahao
 * @version 1.0 </p> 修改时间：6/9/2019</br> 修改备注：</br>
 */
public class Product {
    private Long productId;
    private String productName;
    private String productDesc;
    //商品的缩略图
    private String imgAddr;
    private String normblePrice;
    // 促销, 宣传价格
    private String promotionPrice;
    private Integer priority;
    private Date createtime;
    private Date lastModifyTime;
    //0下架 1展示
    private Integer enableStatus;


    private List<ProductImg> productImgList;
    private ProductCategory productCategory;
    private Shop shop;

    public List<ProductImg> getProductImgList() {
        return productImgList;
    }

    public void setProductImgList(List<ProductImg> productImgList) {
        this.productImgList = productImgList;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getImgAddr() {
        return imgAddr;
    }

    public void setImgAddr(String imgAddr) {
        this.imgAddr = imgAddr;
    }

    public String getNormblePrice() {
        return normblePrice;
    }

    public void setNormblePrice(String normblePrice) {
        this.normblePrice = normblePrice;
    }

    public String getPromotionPrice() {
        return promotionPrice;
    }

    public void setPromotionPrice(String promotionPrice) {
        this.promotionPrice = promotionPrice;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
}
