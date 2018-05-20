package com.mmbaby.shop.domainservice;

import com.mmbaby.shop.dto.domain.ShopDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:37
 */
public interface IShopDomainService {

    /**
     * 保存或者更新商家信息
     * @param shopDTO
     * @return
     */
    ShopDTO saveSelective(ShopDTO shopDTO);

    /**
     * 查询所有的商家
     * @return
     */
    List<ShopDTO> queryAllShop();

    /**
     * 根据id 查询商家信息
     * @param shopId
     * @return
     */
    ShopDTO queryShopById(Integer shopId);
}
