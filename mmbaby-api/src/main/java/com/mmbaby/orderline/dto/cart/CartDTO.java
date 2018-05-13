package com.mmbaby.orderline.dto.cart;

import com.mmbaby.orderline.dto.domain.OrderLineDTO;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 16:50
 *
 * 购物车
 */
public class CartDTO implements Serializable {

    private static final long serialVersionUID = 432033476429034017L;

    private Map<Integer, OrderLineDTO> itemMap;


}
