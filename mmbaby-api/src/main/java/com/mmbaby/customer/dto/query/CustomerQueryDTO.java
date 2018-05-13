package com.mmbaby.customer.dto.query;

import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.order.dto.domain.OrderDTO;
import com.mmbaby.orderline.dto.cart.CartDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 16:55
 */

@Getter
@Setter
@ToString
public class CustomerQueryDTO implements Serializable {

    private static final long serialVersionUID = 585948623555134017L;

    private Integer id;

    private String customerName;

    private String mobile;

    private String email;

    private String headPicture;

    private String password;

    private Boolean sex;

    private Boolean validity;

    private String registerIp;

    private Date registerTime;

    private Date updateTime;

    private Integer points;

    private Date lastLogintime;

    private String updateId;

    private Integer customerLevel;

    private String address;

    private Integer country;

    private Integer province;

    private Integer city;

    /**
     * 订单list
     */
    private List<OrderDTO> orderList;

    /**
     * 购物车
     */
    private CartDTO cart;

    /**
     * 默认收货地址
     */
    private AddressDTO defaultAddress;

    /**
     * 收货地址
     *
     */
    private List<AddressDTO> addressList;
}
