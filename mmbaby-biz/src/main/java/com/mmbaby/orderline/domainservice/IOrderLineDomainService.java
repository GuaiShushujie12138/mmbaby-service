package com.mmbaby.orderline.domainservice;

import com.mmbaby.orderline.dto.domain.OrderLineDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:16
 */
public interface IOrderLineDomainService {

    /**
     * 保存或者更新订单项
     * @param orderLineDTO
     * @return
     */
    OrderLineDTO saveSelective(OrderLineDTO orderLineDTO);

    /**
     * 根据订单id查询订单项list数据
     * @param orderId
     * @return
     */
    List<OrderLineDTO> queryOrderLineListByOrderId(Integer orderId);
}
