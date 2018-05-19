package com.mmbaby.product.dto.domain;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:22
 */
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = 432037946429034017L;

    private Integer id;

    private String name;

    private Long shopId;

    private Integer inventory;

    private Double price;

    private Double discountPrice;

    private Integer discount;

    private Boolean hot;

    private Boolean recommend;

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

    public Boolean getHot() {
        return hot;
    }

    public void setHot(Boolean hot) {
        this.hot = hot;
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
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
        this.pic = pic;
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
        this.createId = createId;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Boolean getValidity() {
        return validity;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("shopId", shopId)
                .add("inventory", inventory)
                .add("price", price)
                .add("discountPrice", discountPrice)
                .add("discount", discount)
                .add("hot", hot)
                .add("recommend", recommend)
                .add("sales", sales)
                .add("pic", pic)
                .add("priceRegion", priceRegion)
                .add("type", type)
                .add("sex", sex)
                .add("ageRegion", ageRegion)
                .add("category", category)
                .add("createTime", createTime)
                .add("updateTime", updateTime)
                .add("createId", createId)
                .add("updateId", updateId)
                .add("validity", validity)
                .toString();
    }
}
