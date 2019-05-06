package com.mmbaby.order.domainservice.impl;


import com.mmbaby.order.domainservice.IOrderDomainService;
import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.order.entity.OrderEntity;
import com.mmbaby.order.entity.OrderEntityExample;
import com.mmbaby.order.mapper.OrderEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:12
 */

@Service
public class OrderDomainServiceImpl implements IOrderDomainService {

    @Autowired
    private OrderEntityMapper orderEntityMapper;

    /**
     * 保存或者更新订单
     *
     * @param orderDTO
     * @return
     */
    @Override
    public OrderDTO saveSelective(OrderDTO orderDTO) {

        if (orderDTO == null) {
            return orderDTO;
        }

        OrderEntity orderEntity = dto2Entity(orderDTO);

        if (orderEntity.getId() == null) {
            orderEntityMapper.insertSelective(orderEntity);
        } else {
            orderEntityMapper.updateByPrimaryKeySelective(orderEntity);
        }

        return entity2Dto(orderEntity);
    }

    /**
     * 根据order id 查询订单信息
     *
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO queryById(Integer orderId) {
        OrderEntity orderEntity = orderEntityMapper.selectByPrimaryKey(orderId);

        return entity2Dto(orderEntity);
    }

    private OrderDTO entity2Dto(OrderEntity entity) {

        if (null == entity) {
            return null;
        }
        OrderDTO dto = new OrderDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private OrderDTO entity2Dto(OrderEntity entity, OrderDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private OrderEntity dto2Entity(OrderDTO dto) {

        if (null == dto) {
            return null;
        }
        OrderEntity entity = new OrderEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private OrderEntity dto2Entity(OrderDTO dto, OrderEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
