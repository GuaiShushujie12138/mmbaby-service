package com.mmbaby.information.mapper;

import com.mmbaby.information.entity.InformationEntity;
import com.mmbaby.information.entity.InformationEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationEntityMapper {
    int countByExample(InformationEntityExample example);

    int deleteByExample(InformationEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InformationEntity record);

    int insertSelective(InformationEntity record);

    List<InformationEntity> selectByExample(InformationEntityExample example);

    InformationEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InformationEntity record, @Param("example") InformationEntityExample example);

    int updateByExample(@Param("record") InformationEntity record, @Param("example") InformationEntityExample example);

    int updateByPrimaryKeySelective(InformationEntity record);

    int updateByPrimaryKey(InformationEntity record);
}