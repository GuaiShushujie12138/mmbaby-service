package com.mmbaby.region.mapper;

import com.mmbaby.region.entity.RegionEntity;
import com.mmbaby.region.entity.RegionEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegionEntityMapper {
    int countByExample(RegionEntityExample example);

    int deleteByExample(RegionEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RegionEntity record);

    int insertSelective(RegionEntity record);

    List<RegionEntity> selectByExample(RegionEntityExample example);

    RegionEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RegionEntity record, @Param("example") RegionEntityExample example);

    int updateByExample(@Param("record") RegionEntity record, @Param("example") RegionEntityExample example);

    int updateByPrimaryKeySelective(RegionEntity record);

    int updateByPrimaryKey(RegionEntity record);
}