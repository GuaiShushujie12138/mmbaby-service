package com.mmbaby.user.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 15:35
 *
 * user 性别枚举
 */
public enum UserSexEnum {

    MALE(Integer.valueOf(10), "男"),
    FEMALE(Integer.valueOf(20), "女")
    ;

    private Integer code;

    private String name;

    private UserSexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static UserSexEnum getByCode(Integer code) {
        for (UserSexEnum userSexEnum : values()) {
            if (userSexEnum.getCode().equals(code)) {
                return userSexEnum;
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
