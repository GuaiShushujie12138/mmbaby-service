package com.mmbaby.comment.domainservice;

import com.mmbaby.comment.dto.domain.CommentDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 10:11
 */
public interface ICommentDomainService {

    /**
     * 保存或者更新评论
     * @param commentDTO
     * @return
     */
    CommentDTO saveSelective(CommentDTO commentDTO);

}
