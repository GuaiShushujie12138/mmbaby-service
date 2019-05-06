package com.mmbaby.customer.mapper;

import com.mmbaby.customer.entity.CustomerEntity;
import com.mmbaby.customer.entity.CustomerEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerEntityMapper {
    int countByExample(CustomerEntityExample example);

    int deleteByExample(CustomerEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CustomerEntity record);

    int insertSelective(CustomerEntity record);

    List<CustomerEntity> selectByExample(CustomerEntityExample example);

    CustomerEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CustomerEntity record, @Param("example") CustomerEntityExample example);

    int updateByExample(@Param("record") CustomerEntity record, @Param("example") CustomerEntityExample example);

    int updateByPrimaryKeySelective(CustomerEntity record);

    int updateByPrimaryKey(CustomerEntity record);
}