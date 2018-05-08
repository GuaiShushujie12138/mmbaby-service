package com.mmbaby.product.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:19
 *
 * 商品适用的性别枚举
 */
public enum ProductFitSexEnum {

    FEMALE(Integer.valueOf(1), "女"),
    MALE(Integer.valueOf(2), "男")
    ;

    private Integer code;

    private String name;

    private ProductFitSexEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProductFitSexEnum getByCode(Integer code) {
        for (ProductFitSexEnum productFitSexEnum : values()) {
            if (productFitSexEnum.getCode().equals(code)) {
                return productFitSexEnum;
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
