package com.mmbaby.shop.service.impl;

import com.mmbaby.base.util.ErrorResult;
import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.shop.bizservice.IShopQueryBizService;
import com.mmbaby.shop.dto.domain.ShopDTO;
import com.mmbaby.shop.service.ShopQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 9:10
 */

@Service("shopQueryService")
public class ShopQueryServiceImpl implements ShopQueryService {

    @Autowired
    private IShopQueryBizService shopQueryBizService;

    /**
     * 查询所有的商家
     *
     * @return
     */
    @Override
    public GeneralResult<List<ShopDTO>> queryAllShop() {
        List<ShopDTO> shopList = shopQueryBizService.queryAllShop();

        return new GeneralResult<>(shopList);
    }

    /**
     * 根据id 查询商家信息
     *
     * @return
     */
    @Override
    public GeneralResult<ShopDTO> queryShopById(Long shopId) {
        ShopDTO shopDTO = shopQueryBizService.queryShopById(shopId);

        if (shopDTO == null) {
            return new ErrorResult("查询不到该商家信息");
        }

        return new GeneralResult<>(shopDTO);
    }
}
