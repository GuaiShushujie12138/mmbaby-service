package com.mmbaby.order.mapper;

import com.mmbaby.order.entity.OrderEntity;
import com.mmbaby.order.entity.OrderEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderEntityMapper {
    int countByExample(OrderEntityExample example);

    int deleteByExample(OrderEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderEntity record);

    int insertSelective(OrderEntity record);

    List<OrderEntity> selectByExample(OrderEntityExample example);

    OrderEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderEntity record, @Param("example") OrderEntityExample example);

    int updateByExample(@Param("record") OrderEntity record, @Param("example") OrderEntityExample example);

    int updateByPrimaryKeySelective(OrderEntity record);

    int updateByPrimaryKey(OrderEntity record);
}