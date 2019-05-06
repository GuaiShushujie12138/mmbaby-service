package com.mmbaby.orderline.bizservice.impl;

import com.mmbaby.orderline.bizservice.IOrderLineQueryBizService;
import com.mmbaby.orderline.domainservice.IOrderLineDomainService;
import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/23 at 7:18
 */

@Service
public class OrderLineQueryServiceImpl implements IOrderLineQueryBizService {

    @Autowired
    private IOrderLineDomainService orderLineDomainService;

    /**
     * 根据订单id查询订单项list信息
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderLineDTO> queryOrderListByOrderId(Integer orderId) {
        return orderLineDomainService.queryOrderLineListByOrderId(orderId);
    }
}
