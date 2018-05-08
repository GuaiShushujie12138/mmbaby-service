package com.mmbaby.order.enums;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/8 at 16:43
 *
 * 订单状态枚举
 */
public enum OrderStatusEnum {

    WAIT_PAY(Integer.valueOf(10), "待支付"),
    WAIT_RECEIVE(Integer.valueOf(20), "待收货"),
    WAIT_COMMENT(Integer.valueOf(30), "待评价"),
    FINISH(Integer.valueOf(40), "完成"),
    CANCEL(Integer.valueOf(100), "取消")
    ;

    private Integer code;

    private String name;

    private OrderStatusEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public static OrderStatusEnum getByCode(Integer code) {
        for (OrderStatusEnum orderStatusEnum : values()) {
            if (orderStatusEnum.getCode().equals(code)) {
                return orderStatusEnum;
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
