package com.mmbaby.order.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/10 at 19:59
 *
 * 订单物流枚举
 */
public enum OrderLogisticsEnum {

    SHUN_FENG(Integer.valueOf(10), "顺丰速递"),
    EMS(Integer.valueOf(20), "EMS速递"),
    DEBON(Integer.valueOf(30), "德邦快运"),
    OTHER(Integer.valueOf(40), "任意物流")
    ;

    private Integer code;

    private String name;

    private OrderLogisticsEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static OrderLogisticsEnum getByCode(Integer code) {
        for (OrderLogisticsEnum orderLogisticsEnum : values()) {
            if (orderLogisticsEnum.getCode().equals(code)) {
                return orderLogisticsEnum;
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
