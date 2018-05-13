package com.mmbaby.address.mapper;

import com.mmbaby.address.entity.AddressEntity;
import com.mmbaby.address.entity.AddressEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressEntityMapper {
    int countByExample(AddressEntityExample example);

    int deleteByExample(AddressEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressEntity record);

    int insertSelective(AddressEntity record);

    List<AddressEntity> selectByExample(AddressEntityExample example);

    AddressEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressEntity record, @Param("example") AddressEntityExample example);

    int updateByExample(@Param("record") AddressEntity record, @Param("example") AddressEntityExample example);

    int updateByPrimaryKeySelective(AddressEntity record);

    int updateByPrimaryKey(AddressEntity record);
}