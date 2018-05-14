package com.mmbaby.order.bizservice;

import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.order.dto.submitbiz.OrderSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 11:32
 */
public interface IOrderSubmitBizService {

    /**
     * 保存订单
     * @param orderSubmitDTO
     * @return
     */
    OrderDTO saveOrder(OrderSubmitDTO orderSubmitDTO);

}
