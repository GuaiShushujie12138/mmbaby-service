package com.mmbaby.order.dto.domain;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:09
 */
public class OrderDTO implements Serializable {

    private static final long serialVersionUID = 585236756429034017L;

    private Integer id;

    private Integer customerId;

    private Double amount;

    private Integer number;

    private Double freight;

    private String leaveMessage;

    private Integer logistics;

    private Integer addressId;

    private Integer status;

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public Double getFreight() {
        return freight;
    }

    public void setFreight(Double freight) {
        this.freight = freight;
    }

    public String getLeaveMessage() {
        return leaveMessage;
    }

    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    public Integer getLogistics() {
        return logistics;
    }

    public void setLogistics(Integer logistics) {
        this.logistics = logistics;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
                .add("customerId", customerId)
                .add("amount", amount)
                .add("number", number)
                .add("freight", freight)
                .add("leaveMessage", leaveMessage)
                .add("logistics", logistics)
                .add("addressId", addressId)
                .add("status", status)
                .add("createTime", createTime)
                .add("updateTime", updateTime)
                .add("createId", createId)
                .add("updateId", updateId)
                .add("validity", validity)
                .toString();
    }
}
