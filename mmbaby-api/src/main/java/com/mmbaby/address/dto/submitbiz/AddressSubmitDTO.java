package com.mmbaby.address.dto.submitbiz;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 19:44
 */

@Getter
@Setter
@ToString
public class AddressSubmitDTO implements Serializable {

    private static final long serialVersionUID = 585943683555488017L;

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
}
