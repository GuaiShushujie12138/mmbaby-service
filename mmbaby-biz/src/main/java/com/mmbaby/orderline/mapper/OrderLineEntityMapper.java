package com.mmbaby.orderline.mapper;

import com.mmbaby.orderline.entity.OrderLineEntity;
import com.mmbaby.orderline.entity.OrderLineEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderLineEntityMapper {
    int countByExample(OrderLineEntityExample example);

    int deleteByExample(OrderLineEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderLineEntity record);

    int insertSelective(OrderLineEntity record);

    List<OrderLineEntity> selectByExample(OrderLineEntityExample example);

    OrderLineEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderLineEntity record, @Param("example") OrderLineEntityExample example);

    int updateByExample(@Param("record") OrderLineEntity record, @Param("example") OrderLineEntityExample example);

    int updateByPrimaryKeySelective(OrderLineEntity record);

    int updateByPrimaryKey(OrderLineEntity record);
}