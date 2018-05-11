
package com.mmbaby.orderline.domainservice.impl;

import com.mmbaby.orderline.domainservice.IOrderLineDomainService;
import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import com.mmbaby.orderline.entity.OrderLineEntity;
import com.mmbaby.orderline.mapper.OrderLineEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:19
 */

@Service
public class OrderLineDomainServiceImpl implements IOrderLineDomainService {

    @Autowired
    private OrderLineEntityMapper orderLineEntityMapper;

    /**
     * 保存或者更新订单项
     *
     * @param orderLineDTO
     * @return
     */
    @Override
    public OrderLineDTO saveSelective(OrderLineDTO orderLineDTO) {

        if (orderLineDTO == null) {
            return orderLineDTO;
        }

        OrderLineEntity orderLineEntity = dto2Entity(orderLineDTO);

        if (orderLineEntity.getId() == null) {
            orderLineEntityMapper.insertSelective(orderLineEntity);
        } else {
            orderLineEntityMapper.updateByPrimaryKeySelective(orderLineEntity);
        }

        return entity2Dto(orderLineEntity);
    }

    private OrderLineDTO entity2Dto(OrderLineEntity entity) {

        if (null == entity) {
            return null;
        }
        OrderLineDTO dto = new OrderLineDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private OrderLineDTO entity2Dto(OrderLineEntity entity, OrderLineDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private OrderLineEntity dto2Entity(OrderLineDTO dto) {

        if (null == dto) {
            return null;
        }
        OrderLineEntity entity = new OrderLineEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private OrderLineEntity dto2Entity(OrderLineDTO dto, OrderLineEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}

