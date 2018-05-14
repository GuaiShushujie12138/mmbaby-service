package com.mmbaby.order.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.order.dto.submitbiz.OrderSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 11:30
 */
public interface OrderSubmitService {

    /**
     * 保存订单
     * @param orderSubmitDTO
     * @return
     */
    GeneralResult<OrderDTO> saveOrder(OrderSubmitDTO orderSubmitDTO);

}
