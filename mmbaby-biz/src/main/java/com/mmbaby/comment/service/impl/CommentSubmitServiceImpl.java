package com.mmbaby.comment.service.impl;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.comment.dto.domain.CommentDTO;
import com.mmbaby.comment.dto.submitbiz.CommentSubmitDTO;
import com.mmbaby.comment.service.CommentSubmitService;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 19:35
 */

@Service("commentSubmitService")
public class CommentSubmitServiceImpl implements CommentSubmitService {
    /**
     * 保存评论
     *
     * @param commentSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<CommentDTO> saveComment(CommentSubmitDTO commentSubmitDTO) {
        return null;
    }
}
