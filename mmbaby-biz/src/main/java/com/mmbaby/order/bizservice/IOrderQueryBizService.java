package com.mmbaby.order.bizservice;

import com.mmbaby.order.dto.domain.OrderDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/19 at 10:18
 */
public interface IOrderQueryBizService {

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     */
    OrderDTO queryOrderById(Integer orderId);

}
