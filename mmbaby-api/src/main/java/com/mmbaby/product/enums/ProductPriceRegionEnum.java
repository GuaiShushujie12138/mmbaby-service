package com.mmbaby.product.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:12
 *
 * 商品价格区间枚举
 */
public enum ProductPriceRegionEnum {

    LOWER_SIXTY(Integer.valueOf(10), "0-60"),
    LOWER_HUNDER(Integer.valueOf(20), "61-100"),
    LOWER_TWO_HUNDER(Integer.valueOf(30), "101-200"),
    LOWER_FOUR_HUNDER(Integer.valueOf(40), "201-400"),
    LOWER_THOUNSDER(Integer.valueOf(50), "401-1000"),
    HIGHER_THOUNSDER(Integer.valueOf(60), "1000-");

    private Integer code;

    private String name;

    private ProductPriceRegionEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProductPriceRegionEnum getByCode(Integer code) {
        for (ProductPriceRegionEnum productPriceRegionEnum : values()) {
            if (productPriceRegionEnum.getCode().equals(code)) {
                return productPriceRegionEnum;
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
