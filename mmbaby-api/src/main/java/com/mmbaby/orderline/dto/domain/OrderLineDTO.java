package com.mmbaby.orderline.dto.domain;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:16
 */
public class OrderLineDTO implements Serializable {

    private static final long serialVersionUID = 432036756429034017L;

    private Integer id;

    private Integer itemId;

    private Integer orderId;

    private Double amount;

    private Integer number;

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

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
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

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("itemId", itemId)
                .add("amount", amount)
                .add("number", number)
                .add("orderId", orderId)
                .add("createTime", createTime)
                .add("updateTime", updateTime)
                .add("createId", createId)
                .add("updateId", updateId)
                .add("validity", validity)
                .toString();
    }
}
