package com.mmbaby.customer.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:03
 *
 * 客户等级枚举
 */
public enum  CustomerLevelEnum {

    NORMAL_CUSTOMER(Integer.valueOf(0), "普通客户"),
    SEED_CUSTOMER(Integer.valueOf(1), "种子客户"),
    VIP_CUSTOMER(Integer.valueOf(2), "VIP客户")
    ;

    private Integer code;

    private String name;

    private CustomerLevelEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static CustomerLevelEnum getByCode(Integer code) {
        for (CustomerLevelEnum customerLevelEnum : values()) {
            if (customerLevelEnum.getCode().equals(code)) {
                return customerLevelEnum;
            }
        }

        return null;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
