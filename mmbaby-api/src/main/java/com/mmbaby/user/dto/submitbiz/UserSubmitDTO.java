package com.mmbaby.user.dto.submitbiz;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 14:55
 */
public class UserSubmitDTO implements Serializable {

    private static final long serialVersionUID = 432077466333904017L;

    private Integer id;

    private String userName;

    private String mobile;

    private String headPicture;

    private String password;

    private Integer sex;

    private Integer role;

    private Boolean validity;

    private String address;

    private Integer country;

    private Integer province;

    private Integer city;

    private String createId;

    private String updateId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Boolean getValidity() {
        return validity;
    }

    public void setValidity(Boolean validity) {
        this.validity = validity;
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
                .add("userName", userName)
                .add("updateId", updateId)
                .add("createId", createId)
                .add("mobile", mobile)
                .add("headPicture", headPicture)
                .add("password", password)
                .add("sex", sex)
                .add("role", role)
                .add("address", address)
                .add("country", country)
                .add("province", province)
                .add("city", city)
                .add("validity", validity)
                .toString();
    }
}
