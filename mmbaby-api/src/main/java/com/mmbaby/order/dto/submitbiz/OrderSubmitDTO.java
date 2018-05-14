package com.mmbaby.order.dto.submitbiz;

import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 11:27
 */

@Getter
@Setter
@ToString
public class OrderSubmitDTO implements Serializable {

    private static final long serialVersionUID = 585123456429034017L;

    private Integer id;

    private Integer customerId;

    private Double amount;

    private Integer number;

    private Double freight;

    private String leaveMessage;

    private Integer logistics;

    private Integer addressId;

    private Integer status;

    /**
     * 订单项
     */
    private List<OrderLineDTO> orderLineList;
}
