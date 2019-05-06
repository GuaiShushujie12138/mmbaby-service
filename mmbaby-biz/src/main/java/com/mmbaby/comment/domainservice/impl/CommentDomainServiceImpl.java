package com.mmbaby.comment.domainservice.impl;

import com.mmbaby.comment.domainservice.ICommentDomainService;
import com.mmbaby.comment.dto.domain.CommentDTO;
import com.mmbaby.comment.entity.CommentEntity;
import com.mmbaby.comment.mapper.CommentEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 10:20
 */

@Service
public class CommentDomainServiceImpl implements ICommentDomainService {

    @Autowired
    private CommentEntityMapper commentEntityMapper;

    /**
     * 保存或者更新评论
     *
     * @param commentDTO
     * @return
     */
    @Override
    public CommentDTO saveSelective(CommentDTO commentDTO) {

        if (commentDTO == null) {
            return commentDTO;
        }

        CommentEntity commentEntity = dto2Entity(commentDTO);

        if (commentEntity.getId() == null) {
            commentEntityMapper.insertSelective(commentEntity);
        } else {
            commentEntityMapper.updateByPrimaryKeySelective(commentEntity);
        }

        return entity2Dto(commentEntity);
    }

    private CommentDTO entity2Dto(CommentEntity entity) {

        if (null == entity) {
            return null;
        }
        CommentDTO dto = new CommentDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private CommentDTO entity2Dto(CommentEntity entity, CommentDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private CommentEntity dto2Entity(CommentDTO dto) {

        if (null == dto) {
            return null;
        }
        CommentEntity entity = new CommentEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private CommentEntity dto2Entity(CommentDTO dto, CommentEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
