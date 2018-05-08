package com.mmbaby.product.entity;

import java.util.Date;

public class ProductEntity {
    private Integer id;

    private Long shopId;

    private Integer inventory;

    private Double price;

    private Double discountPrice;

    private Integer discount;

    private Integer sales;

    private String pic;

    private Integer priceRegion;

    private Integer type;

    private Integer sex;

    private Integer ageRegion;

    private Integer category;

    private Date createTime;

    private Date updateTime;

    private String createId;

    private String updateId;

    private Boolean validity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(Double discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Integer getPriceRegion() {
        return priceRegion;
    }

    public void setPriceRegion(Integer priceRegion) {
        this.priceRegion = priceRegion;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAgeRegion() {
        return ageRegion;
    }

    public void setAgeRegion(Integer ageRegion) {
        this.ageRegion = ageRegion;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId == null ? null : createId.trim();
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId == null ? null : updateId.trim();
    }

    public Boolean getValidity() {
        return validity;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
    }
}