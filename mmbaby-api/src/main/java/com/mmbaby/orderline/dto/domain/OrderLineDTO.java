package com.mmbaby.orderline.dto.domain;

import com.google.common.base.MoreObjects;
import com.mmbaby.product.dto.domain.ProductDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:16
 */

@Getter
@Setter
@ToString
public class OrderLineDTO implements Serializable {

    private static final long serialVersionUID = 432036756429034017L;

    private Integer id;

    private Integer itemId;

    private ProductDTO product;

    private Integer orderId;

    private Double amount;

    private Integer number;

    private Date createTime;

    private Date updateTime;

    private String createId;

    private String updateId;

    private Boolean validity;
}
