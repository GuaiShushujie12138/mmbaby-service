package com.mmbaby.order.service.impl;

import com.mmbaby.base.util.ErrorResult;
import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.order.bizservice.IOrderQueryBizService;
import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.order.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/19 at 10:16
 */

@Service("orderQueryService")
public class OrderQueryServiceImpl implements OrderQueryService {

    @Autowired
    private IOrderQueryBizService orderQueryBizService;

    @Override
    public GeneralResult<OrderDTO> queryOrderById(Integer orderId) {
        OrderDTO orderDTO = orderQueryBizService.queryOrderById(orderId);

        if (orderDTO == null) {
            return new ErrorResult("查询不到该订单");
        }

        return new GeneralResult<>(orderDTO);
    }
}
