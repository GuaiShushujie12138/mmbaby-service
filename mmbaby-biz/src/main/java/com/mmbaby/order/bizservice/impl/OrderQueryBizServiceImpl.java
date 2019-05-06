package com.mmbaby.order.bizservice.impl;

import com.mmbaby.order.bizservice.IOrderQueryBizService;
import com.mmbaby.order.domainservice.IOrderDomainService;
import com.mmbaby.order.dto.domain.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/19 at 10:19
 */

@Service
public class OrderQueryBizServiceImpl implements IOrderQueryBizService {

    @Autowired
    private IOrderDomainService orderDomainService;

    /**
     * 根据订单id查询订单
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO queryOrderById(Integer orderId) {
        return orderDomainService.queryById(orderId);
    }
}
