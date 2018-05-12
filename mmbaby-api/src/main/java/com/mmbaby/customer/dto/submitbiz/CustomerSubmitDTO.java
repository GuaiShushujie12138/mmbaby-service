package com.mmbaby.customer.dto.submitbiz;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/12 at 10:35
 */
public class CustomerSubmitDTO implements Serializable {

    private static final long serialVersionUID = 58594432895134017L;

    private String customerName;

    private String mobile;

    private String email;

    private String headPicture;

    private String password;

    private Boolean sex;

    private String registerIp;

    private Integer points;

    private String address;

    private Integer country;

    private Integer province;

    private Integer city;

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

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
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
                .add("customerName", customerName)
                .add("mobile", mobile)
                .add("email", email)
                .add("headPicture", headPicture)
                .add("password", password)
                .add("registerIp", registerIp)
                .add("sex", sex)
                .add("points", points)
                .add("address", address)
                .add("country", country)
                .add("province", province)
                .add("city", city)
                .toString();
    }
}
