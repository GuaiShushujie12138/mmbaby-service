package com.mmbaby.shop.mapper;

import com.mmbaby.shop.entity.ShopEntity;
import com.mmbaby.shop.entity.ShopEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopEntityMapper {
    int countByExample(ShopEntityExample example);

    int deleteByExample(ShopEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopEntity record);

    int insertSelective(ShopEntity record);

    List<ShopEntity> selectByExample(ShopEntityExample example);

    ShopEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShopEntity record, @Param("example") ShopEntityExample example);

    int updateByExample(@Param("record") ShopEntity record, @Param("example") ShopEntityExample example);

    int updateByPrimaryKeySelective(ShopEntity record);

    int updateByPrimaryKey(ShopEntity record);
}