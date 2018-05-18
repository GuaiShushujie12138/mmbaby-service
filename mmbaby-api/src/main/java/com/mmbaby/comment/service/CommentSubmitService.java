package com.mmbaby.comment.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.comment.dto.domain.CommentDTO;
import com.mmbaby.comment.dto.submitbiz.CommentSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 19:31
 */
public interface CommentSubmitService {

    /**
     * 保存评论
     * @param commentSubmitDTO
     * @return
     */
    GeneralResult<CommentDTO> saveComment(CommentSubmitDTO commentSubmitDTO);

}
