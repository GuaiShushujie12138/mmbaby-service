package com.mmbaby.product.dto.submitbiz;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:07
 */

@Getter
@Setter
@ToString
public class ProductSubmitDTO implements Serializable {

    private static final long serialVersionUID = 432037533309034017L;

    private Integer id;

    private String name;

    private Long shopId;

    private Integer inventory;

    private Double price;

    private Double discountPrice;

    private Integer discount;

    private Boolean hot;

    private Boolean recommend;

    private String pic;

    private Integer priceRegion;

    private Integer type;

    private Integer sex;

    private Integer ageRegion;

    private Integer category;

    private Boolean validity;
}
