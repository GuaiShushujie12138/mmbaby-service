package com.mmbaby.order.service.impl;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.order.bizservice.IOrderSubmitBizService;
import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.order.dto.submitbiz.OrderSubmitDTO;
import com.mmbaby.order.service.OrderSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 11:31
 */

@Service("orderSubmitService")
public class OrderSubmitServiceImpl implements OrderSubmitService {

    @Autowired
    private IOrderSubmitBizService orderSubmitBizService;

    /**
     * 保存订单
     *
     * @param orderSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<OrderDTO> saveOrder(OrderSubmitDTO orderSubmitDTO) {
        OrderDTO orderDTO = orderSubmitBizService.saveOrder(orderSubmitDTO);

        return new GeneralResult(orderDTO);
    }
}
