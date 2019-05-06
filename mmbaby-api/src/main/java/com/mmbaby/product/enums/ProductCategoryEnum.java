package com.mmbaby.product.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:29
 *
 * 商品小类型枚举
 */
public enum ProductCategoryEnum {

    DIAPER(Integer.valueOf(10), "纸尿裤"),
    PRAM(Integer.valueOf(20), "婴儿车"),
    BABY_MILK(Integer.valueOf(30), "婴儿奶粉"),
    SAFETY_SEAT(Integer.valueOf(40), "安全座椅"),
    TOY(Integer.valueOf(50), "玩具"),
    CHILD_CLOTH(Integer.valueOf(60), "童装"),
    CHILD_SHOE(Integer.valueOf(70), "童鞋"),
    CHILD_FOOD(Integer.valueOf(80), "婴儿食品"),
    FEEDING(Integer.valueOf(90), "喂养"),
    CHILD_HEALTHY(Integer.valueOf(100), "宝宝健康"),
    HEALTHY_PRODUCT(Integer.valueOf(300), "保健品"),
    PERSON_CARE(Integer.valueOf(310), "个人护理"),
    SANITARY_PRODUCT(Integer.valueOf(320), "卫生用品"),
    NUTRITION(Integer.valueOf(330), "孕后/产期营养"),
    MOM_CLOTH(Integer.valueOf(340), "辣妈衣装")
    ;

    private Integer code;

    private String name;

    private ProductCategoryEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static ProductCategoryEnum getByCode(Integer code) {
        for (ProductCategoryEnum productCategoryEnum : values()) {
            if (productCategoryEnum.getCode().equals(code)) {
                return productCategoryEnum;
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
