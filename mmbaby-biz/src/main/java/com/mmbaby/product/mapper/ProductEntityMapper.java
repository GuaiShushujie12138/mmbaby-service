package com.mmbaby.product.mapper;

import com.mmbaby.product.entity.ProductEntity;
import com.mmbaby.product.entity.ProductEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductEntityMapper {
    int countByExample(ProductEntityExample example);

    int deleteByExample(ProductEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductEntity record);

    int insertSelective(ProductEntity record);

    List<ProductEntity> selectByExample(ProductEntityExample example);

    ProductEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductEntity record, @Param("example") ProductEntityExample example);

    int updateByExample(@Param("record") ProductEntity record, @Param("example") ProductEntityExample example);

    int updateByPrimaryKeySelective(ProductEntity record);

    int updateByPrimaryKey(ProductEntity record);
}