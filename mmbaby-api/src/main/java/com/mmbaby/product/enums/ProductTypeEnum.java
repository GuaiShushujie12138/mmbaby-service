package com.mmbaby.product.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:17
 *
 * 商品大类型枚举
 */
public enum  ProductTypeEnum {

    BABY(Integer.valueOf(1), "婴儿"),
    MOM(Integer.valueOf(2), "妈妈")
    ;

    private Integer code;

    private String name;

    private ProductTypeEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProductTypeEnum getByCode(Integer code) {
        for (ProductTypeEnum productTypeEnum : values()) {
            if (productTypeEnum.getCode().equals(code)) {
                return productTypeEnum;
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
