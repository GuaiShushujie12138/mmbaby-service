package com.mmbaby.order.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.order.dto.domain.OrderDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/19 at 10:15
 */
public interface OrderQueryService {

    /**
     * 根据订单id查询订单
     * @param orderId
     * @return
     */
    GeneralResult<OrderDTO> queryOrderById(Integer orderId);

}
