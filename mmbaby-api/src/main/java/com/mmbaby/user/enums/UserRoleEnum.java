package com.mmbaby.user.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 15:56
 *
 * user 角色枚举
 */
public enum UserRoleEnum {

    NORMAL_ADMIN(Integer.valueOf(0), "普通管理员"),
    SUPER_ADMIN(Integer.valueOf(10), "超级管理员"),
    PRODUCT_ADMIN(Integer.valueOf(20), "商品管理员"),
    INFO_ADMIN(Integer.valueOf(30), "资讯管理员")
    ;

    private Integer code;

    private String name;

    private UserRoleEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static UserRoleEnum getByCode(Integer code) {
        for (UserRoleEnum userRoleEnum : values()) {
            if (userRoleEnum.getCode().equals(code)) {
                return userRoleEnum;
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
