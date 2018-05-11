package com.mmbaby.shop.domainservice;

import com.mmbaby.shop.dto.domain.ShopDTO;

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

}
