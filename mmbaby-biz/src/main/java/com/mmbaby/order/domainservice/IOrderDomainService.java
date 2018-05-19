package com.mmbaby.order.domainservice;

import com.mmbaby.order.dto.domain.OrderDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:08
 */
public interface IOrderDomainService {

    /**
     * 保存或者更新订单
     * @param orderDTO
     * @return
     */
    OrderDTO saveSelective(OrderDTO orderDTO);

    /**
     * 根据order id 查询订单信息
     * @param orderId
     * @return
     */
    OrderDTO queryById(Integer orderId);
}
