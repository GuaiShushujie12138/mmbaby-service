package com.mmbaby.orderline.bizservice;

import com.mmbaby.orderline.dto.domain.OrderLineDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/23 at 7:16
 */
public interface IOrderLineQueryBizService {

    /**
     * 根据订单id查询订单项list信息
     * @param orderId
     * @return
     */
    List<OrderLineDTO> queryOrderListByOrderId(Integer orderId);

}
