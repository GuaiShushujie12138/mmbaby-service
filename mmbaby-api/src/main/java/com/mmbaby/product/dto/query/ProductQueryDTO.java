package com.mmbaby.product.dto.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 18:59
 */

@Getter
@Setter
@ToString
public class ProductQueryDTO implements Serializable {

    private static final long serialVersionUID = 432037548909034017L;

    private Integer id;

    private String name;

    private Long shopId;

    private Integer inventory;

    private Double price;

    private Double discountPrice;

    private Integer discount;

    private Boolean hot;

    private Boolean recommend;

    private Integer sales;

    private String pic;

    private Integer priceRegion;

    private Integer type;

    private Integer sex;

    private Integer ageRegion;

    private Integer category;

    private Date createTime;

    private Date updateTime;

    private String createId;

    private String updateId;

    private Boolean validity;
}
