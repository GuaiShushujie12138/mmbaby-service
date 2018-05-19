package com.mmbaby.orderline.dto.cart;

import com.google.common.collect.Maps;
import com.mmbaby.orderline.dto.domain.OrderLineDTO;
import com.mmbaby.product.dto.domain.ProductDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 16:50
 *
 * 购物车
 */
@Getter
@Setter
@ToString
public class CartDTO implements Serializable {

    private static final long serialVersionUID = 432033476429034017L;

    /**
     * 保存商品的map,通过订单项
     */
    private Map<Integer, OrderLineDTO> productMap;

    public CartDTO() {
        productMap = Maps.newHashMap();
    }

    /**
     * 向购物车中添加商品
     * @param productDTO
     * @param num
     * @return
     */
    public void addProduct(ProductDTO productDTO, Integer num) {
        Integer productId = productDTO.getId();

        if (productMap.containsKey(productId)) {
            OrderLineDTO orderLineDTO = productMap.get(productId);
            orderLineDTO.setProduct(productDTO);
            orderLineDTO.setNumber(orderLineDTO.getNumber() + num);
            orderLineDTO.setAmount(orderLineDTO.getAmount() + productDTO.getPrice() * num);
        } else {
            OrderLineDTO orderLineDTO = new OrderLineDTO();
            orderLineDTO.setProduct(productDTO);
            orderLineDTO.setNumber(num);
            orderLineDTO.setAmount(productDTO.getPrice() * num);
            orderLineDTO.setItemId(productId);

            productMap.put(productId, orderLineDTO);
        }
    }
}
