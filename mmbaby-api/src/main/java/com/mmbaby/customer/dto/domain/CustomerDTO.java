package com.mmbaby.customer.dto.domain;

import com.google.common.base.MoreObjects;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 10:29
 */
public class CustomerDTO implements Serializable {

    private static final long serialVersionUID = 585948623555134017L;

    private Integer id;

    private String customerName;

    private String mobile;

    private String email;

    private String headPicture;

    private String password;

    private Boolean sex;

    private Boolean validity;

    private String registerIp;

    private Date registerTime;

    private Date updateTime;

    private Integer points;

    private Date lastLogintime;

    private String updateId;

    private Integer customerLevel;

    private String address;

    private Integer country;

    private Integer province;

    private Integer city;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadPicture() {
        return headPicture;
    }

    public void setHeadPicture(String headPicture) {
        this.headPicture = headPicture;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Boolean getValidity() {
        return validity;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getLastLogintime() {
        return lastLogintime;
    }

    public void setLastLogintime(Date lastLogintime) {
        this.lastLogintime = lastLogintime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Integer getCustomerLevel() {
        return customerLevel;
    }

    public void setCustomerLevel(Integer customerLevel) {
        this.customerLevel = customerLevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("customerName", customerName)
                .add("mobile", mobile)
                .add("email", email)
                .add("headPicture", headPicture)
                .add("password", password)
                .add("registerIp", registerIp)
                .add("sex", sex)
                .add("registerTime", registerTime)
                .add("updateTime", updateTime)
                .add("points", points)
                .add("lastLogintime", lastLogintime)
                .add("customerLevel", customerLevel)
                .add("address", address)
                .add("country", country)
                .add("province", province)
                .add("city", city)
                .add("validity", validity)
                .toString();
    }
}
