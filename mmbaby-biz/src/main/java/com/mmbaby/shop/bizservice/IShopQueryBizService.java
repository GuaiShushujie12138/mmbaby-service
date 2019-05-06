package com.mmbaby.shop.bizservice;

import com.mmbaby.shop.dto.domain.ShopDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 9:10
 */
public interface IShopQueryBizService {

    /**
     * 查询所有的商家
     * @return
     */
    List<ShopDTO> queryAllShop();

    /**
     * 根据id 查询商家信息
     * @return
     */
    ShopDTO queryShopById(Long shopId);
}
