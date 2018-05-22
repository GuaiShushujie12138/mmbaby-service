
package com.mmbaby.orderline.domainservice.impl;

import com.google.common.collect.Lists;
import com.mmbaby.orderline.domainservice.IOrderLineDomainService;
import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import com.mmbaby.orderline.entity.OrderLineEntity;
import com.mmbaby.orderline.entity.OrderLineEntityExample;
import com.mmbaby.orderline.mapper.OrderLineEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据订单id查询订单项list数据
     *
     * @param orderId
     * @return
     */
    @Override
    public List<OrderLineDTO> queryOrderLineListByOrderId(Integer orderId) {
        OrderLineEntityExample example = new OrderLineEntityExample();
        OrderLineEntityExample.Criteria criteria = example.createCriteria();

        criteria.andOrderIdEqualTo(orderId);
        List<OrderLineEntity> orderLineEntityList = orderLineEntityMapper.selectByExample(example);

        return entity2Dto(orderLineEntityList);
    }

    private List<OrderLineDTO> entity2Dto(List<OrderLineEntity> orderLineEntityList) {
        List<OrderLineDTO> orderLineList = Lists.newArrayList();

        for (OrderLineEntity orderLineEntity : orderLineEntityList) {
            orderLineList.add(entity2Dto(orderLineEntity));
        }

        return orderLineList;
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

