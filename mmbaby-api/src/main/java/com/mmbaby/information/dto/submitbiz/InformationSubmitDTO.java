package com.mmbaby.information.dto.submitbiz;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 20:53
 */

@Getter
@Setter
@ToString
public class InformationSubmitDTO implements Serializable {

    private static final long serialVersionUID = 585236723555224017L;

    private String content;

    private String createId;
}
