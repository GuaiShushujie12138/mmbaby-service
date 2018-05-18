package com.mmbaby.order.bizservice.impl;

import com.dianping.pigeon.util.CollectionUtils;
import com.mmbaby.base.exception.SaveFailedException;
import com.mmbaby.order.bizservice.IOrderSubmitBizService;
import com.mmbaby.order.domainservice.IOrderDomainService;
import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.order.dto.submitbiz.OrderSubmitDTO;
import com.mmbaby.orderline.domainservice.IOrderLineDomainService;
import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 11:32
 */

@Service
public class OrderSubmitBizServiceImpl implements IOrderSubmitBizService {

    @Autowired
    private IOrderDomainService orderDomainService;

    @Autowired
    private IOrderLineDomainService orderLineDomainService;

    /**
     * 保存订单
     *
     * @param orderSubmitDTO
     * @return
     */
    @Override
    public OrderDTO saveOrder(OrderSubmitDTO orderSubmitDTO) {
        checkArgs(orderSubmitDTO);

        OrderDTO orderDTO = buildOrderDTO(orderSubmitDTO);

        OrderDTO returnOrderDTO =
                orderDomainService.saveSelective(orderDTO);

        // 插入订单项数据
        insertOrderLine(returnOrderDTO, orderSubmitDTO);

        return orderDTO;
    }

    /**
     * 检查提交的参数
     * @param orderSubmitDTO
     */
    private void checkArgs(OrderSubmitDTO orderSubmitDTO) {
        if (orderSubmitDTO == null) {
            throw new SaveFailedException("orderSubmitDTO 不能为空");
        }

        if (CollectionUtils.isEmpty(orderSubmitDTO.getOrderLineList())) {
            throw new SaveFailedException("订单中不能没有订单项");
        }
    }

    /**
     * 插入订单项数据
     * @param returnOrderDTO
     * @param orderSubmitDTO
     */
    private void insertOrderLine(OrderDTO returnOrderDTO,
                                 OrderSubmitDTO orderSubmitDTO) {
        Integer orderId = returnOrderDTO.getId();

        for (OrderLineDTO orderLineDTO : orderSubmitDTO.getOrderLineList()) {
            orderLineDTO.setOrderId(orderId);
            orderLineDomainService.saveSelective(orderLineDTO);
        }
    }

    /**
     * 构造OrderDTO 对象
     * @param orderSubmitDTO
     * @return
     */
    private OrderDTO buildOrderDTO(OrderSubmitDTO orderSubmitDTO) {
        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderSubmitDTO, orderDTO);

        return orderDTO;
    }
}
