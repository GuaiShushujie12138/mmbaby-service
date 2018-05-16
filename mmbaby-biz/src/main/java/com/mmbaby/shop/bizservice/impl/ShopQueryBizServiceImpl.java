package com.mmbaby.shop.bizservice.impl;

import com.mmbaby.shop.bizservice.IShopQueryBizService;
import com.mmbaby.shop.domainservice.IShopDomainService;
import com.mmbaby.shop.dto.domain.ShopDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 9:12
 */

@Service
public class ShopQueryBizServiceImpl implements IShopQueryBizService {

    @Autowired
    private IShopDomainService shopDomainService;

    /**
     * 查询所有的商家
     *
     * @return
     */
    @Override
    public List<ShopDTO> queryAllShop() {
        return shopDomainService.queryAllShop();
    }
}
