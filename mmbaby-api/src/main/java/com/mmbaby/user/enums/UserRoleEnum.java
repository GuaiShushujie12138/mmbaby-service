package com.mmbaby.user.enums;

import com.mmbaby.base.constants.Constants;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 15:56
 *
 * user 角色枚举
 */
public enum UserRoleEnum {

    NORMAL_ADMIN(Integer.valueOf(0), "普通管理员", Constants.NORMAL_ADMIN),
    SUPER_ADMIN(Integer.valueOf(10), "超级管理员", Constants.SUPER_ADMIN),
    PRODUCT_ADMIN(Integer.valueOf(20), "商品管理员", Constants.PRODUCT_ADMIN),
    INFO_ADMIN(Integer.valueOf(30), "资讯管理员", Constants.INFO_ADMIN)
    ;

    private Integer code;

    private String name;

    private String msg;

    private UserRoleEnum(Integer code, String name, String msg) {
        this.code = code;
        this.name = name;
        this.msg = msg;
    }

    /**
     * 根据code 获取UserRoleEnum
     * @param code
     * @return
     */
    public static UserRoleEnum getByCode(Integer code) {
        for (UserRoleEnum userRoleEnum : values()) {
            if (userRoleEnum.getCode().equals(code)) {
                return userRoleEnum;
            }
        }

        return null;
    }

    /**
     * 根据msg 获取UserRoleEnum
     * @param msg
     * @return
     */
    public static UserRoleEnum getByMsg(String msg) {
        for (UserRoleEnum userRoleEnum : values()) {
            if (userRoleEnum.getMsg().equals(msg)) {
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
