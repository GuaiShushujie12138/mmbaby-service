package com.mmbaby.comment.bizservice;

import com.mmbaby.comment.dto.domain.CommentDTO;
import com.mmbaby.comment.dto.submitbiz.CommentSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 19:37
 */
public interface ICommentSubmitBizService {

    /**
     * 保存评论
     * @param commentSubmitDTO
     * @return
     */
    CommentDTO saveComment(CommentSubmitDTO commentSubmitDTO);


}
