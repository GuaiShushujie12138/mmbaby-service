package com.mmbaby.address.dto.domain;

import com.google.common.base.MoreObjects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/10 at 20:10
 */

@Getter
@Setter
@ToString
public class AddressDTO implements Serializable {

    private static final long serialVersionUID = 585948623555488017L;

    private Integer id;

    private Integer customerId;

    private String address;

    private Integer country;

    private Integer province;

    private Integer city;

    private String receiveName;

    private String mobile;

    private String zip;

    private Boolean defaultAddress;

    private Date createTime;

    private Date updateTime;

    private String createId;

    private String updateId;

    private Boolean validity;
}
