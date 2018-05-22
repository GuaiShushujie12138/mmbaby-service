package com.mmbaby.order.bizservice.impl;

import com.dianping.pigeon.util.CollectionUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mmbaby.base.exception.SaveFailedException;
import com.mmbaby.order.bizservice.IOrderSubmitBizService;
import com.mmbaby.order.domainservice.IOrderDomainService;
import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.order.dto.submitbiz.OrderSubmitDTO;
import com.mmbaby.order.enums.OrderStatusEnum;
import com.mmbaby.orderline.domainservice.IOrderLineDomainService;
import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import com.mmbaby.product.domainservice.IProductDomainService;
import com.mmbaby.product.dto.domain.ProductDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Autowired
    private IProductDomainService productDomainService;

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

        return returnOrderDTO;
    }

    /**
     * 更新订单数据
     *
     * @param orderSubmitDTO
     * @return
     */
    @Override
    public OrderDTO updateOrder(OrderSubmitDTO orderSubmitDTO) {
        OrderDTO orderDTO = buildOrder(orderSubmitDTO);

        OrderDTO returnOrderDTO =
                orderDomainService.saveSelective(orderDTO);

        return returnOrderDTO;
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

    /**
     * 构造更新的OrderDTO 对象
     * @param orderSubmitDTO
     * @return
     */
    private OrderDTO buildOrder(OrderSubmitDTO orderSubmitDTO) {
        OrderDTO orderDTO = new OrderDTO();

        BeanUtils.copyProperties(orderSubmitDTO, orderDTO);

        // 判断是否状态改变为取消或者待收货
        if (OrderStatusEnum.WAIT_RECEIVE.getCode().equals(orderSubmitDTO.getStatus())
                || OrderStatusEnum.CANCEL.getCode().equals(orderSubmitDTO.getStatus())) {

            // 根据订单id查询订单项数据
            List<OrderLineDTO> orderLineList =
                    orderLineDomainService.queryOrderLineListByOrderId(orderSubmitDTO.getId());

            OrderStatusEnum orderStatusEnum = OrderStatusEnum.getByCode(orderSubmitDTO.getStatus());

            // 获取订单项中的商品，改变其商品的库存和销量
            List<ProductDTO> productList = Lists.newArrayList();
            Map<Integer, OrderLineDTO> orderLineMap = Maps.newHashMap();
            for (OrderLineDTO orderLineDTO : orderLineList) {
                productList.add(productDomainService.queryProductById(orderLineDTO.getItemId()));
                orderLineMap.put(orderLineDTO.getItemId(), orderLineDTO);
            }


            switch (orderStatusEnum) {
                case CANCEL:
                    for (ProductDTO productDTO : productList) {
                        productDTO.setSales(productDTO.getSales() - orderLineMap.get(productDTO.getId()).getNumber());
                        productDTO.setInventory(productDTO.getInventory() + orderLineMap.get(productDTO.getId()).getNumber());

                        productDomainService.saveSelective(productDTO);
                    }
                    break;
                case WAIT_RECEIVE:
                    for (ProductDTO productDTO : productList) {
                        if (productDTO.getInventory() <= 0) {
                            throw new SaveFailedException("订单中有商品已经卖完了，请确认后重新下单!");
                        }
                        productDTO.setSales(productDTO.getSales() + orderLineMap.get(productDTO.getId()).getNumber());
                        productDTO.setInventory(productDTO.getInventory() - orderLineMap.get(productDTO.getId()).getNumber());

                        productDomainService.saveSelective(productDTO);
                    }
                    break;
                default:
                    break;
            }
        }

        return orderDTO;
    }
}
