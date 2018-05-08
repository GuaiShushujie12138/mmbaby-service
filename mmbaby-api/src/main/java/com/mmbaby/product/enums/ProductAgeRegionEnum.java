package com.mmbaby.product.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:21
 *
 * 商品使用的年龄区间
 */
public enum ProductAgeRegionEnum {

    LOWER_SIX_MONTH(Integer.valueOf(10), "0-6个月宝宝"),
    LOWER_TWELVE_MONTH(Integer.valueOf(20), "6-12个月宝宝"),
    LOWER_THREE_YEARS(Integer.valueOf(30), "1-3岁"),
    LOWER_SIX_YEARS(Integer.valueOf(40), "4-6岁"),
    LOWER_NINE_YEARS(Integer.valueOf(50), "7-9岁"),
    HIGHER_TEN_YEARS(Integer.valueOf(60), "10岁及以上");

    private Integer code;

    private String name;

    private ProductAgeRegionEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProductAgeRegionEnum getByCode(Integer code) {
        for (ProductAgeRegionEnum productAgeRegionEnum : values()) {
            if (productAgeRegionEnum.getCode().equals(code)) {
                return productAgeRegionEnum;
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
