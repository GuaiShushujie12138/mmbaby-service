package com.mmbaby.comment.mapper;

import com.mmbaby.comment.entity.CommentEntity;
import com.mmbaby.comment.entity.CommentEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentEntityMapper {
    int countByExample(CommentEntityExample example);

    int deleteByExample(CommentEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CommentEntity record);

    int insertSelective(CommentEntity record);

    List<CommentEntity> selectByExample(CommentEntityExample example);

    CommentEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CommentEntity record, @Param("example") CommentEntityExample example);

    int updateByExample(@Param("record") CommentEntity record, @Param("example") CommentEntityExample example);

    int updateByPrimaryKeySelective(CommentEntity record);

    int updateByPrimaryKey(CommentEntity record);
}