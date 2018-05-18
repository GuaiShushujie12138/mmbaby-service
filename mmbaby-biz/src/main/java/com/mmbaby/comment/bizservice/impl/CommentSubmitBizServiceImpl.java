package com.mmbaby.comment.bizservice.impl;

import com.mmbaby.comment.bizservice.ICommentSubmitBizService;
import com.mmbaby.comment.domainservice.ICommentDomainService;
import com.mmbaby.comment.dto.domain.CommentDTO;
import com.mmbaby.comment.dto.submitbiz.CommentSubmitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 19:39
 */

@Service
public class CommentSubmitBizServiceImpl implements ICommentSubmitBizService {

    @Autowired
    private ICommentDomainService commentDomainService;

    /**
     * 保存评论
     *
     * @param commentSubmitDTO
     * @return
     */
    @Override
    public CommentDTO saveComment(CommentSubmitDTO commentSubmitDTO) {
        // 构造CommentDTO对象
        CommentDTO commentDTO = buildComment(commentSubmitDTO);

        return commentDomainService.saveSelective(commentDTO);
    }

    /**
     * 构造CommentDTO对象
     * @param commentSubmitDTO
     * @return
     */
    private CommentDTO buildComment(CommentSubmitDTO commentSubmitDTO) {
        CommentDTO commentDTO = new CommentDTO();

        BeanUtils.copyProperties(commentSubmitDTO, commentDTO);

        return commentDTO;
    }
}
