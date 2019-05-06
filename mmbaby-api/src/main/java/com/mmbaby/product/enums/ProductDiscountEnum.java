package com.mmbaby.product.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:09
 *
 * 是否打折
 */
public enum ProductDiscountEnum {

    NOT_DISCOUNT(Integer.valueOf(0), "不打折"),
    DISCOUNT(Integer.valueOf(1), "打折")
    ;

    private Integer code;

    private String name;

    private ProductDiscountEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProductDiscountEnum getByCode(Integer code) {
        for (ProductDiscountEnum productDiscountEnum : values()) {
            if (productDiscountEnum.getCode().equals(code)) {
                return productDiscountEnum;
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
