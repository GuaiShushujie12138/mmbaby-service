package com.mmbaby.comment.dto.submitbiz;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 19:33
 */

@Getter
@Setter
@ToString
public class CommentSubmitDTO implements Serializable {

    private static final long serialVersionUID = 585944367555134017L;

    private Integer customerId;

    private Integer itemId;

    private String content;

    private Integer star;
}
