package com.mmbaby.shop.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.shop.dto.domain.ShopDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 21:46
 */
public interface ShopQueryService {

    /**
     * 查询所有的商家
     * @return
     */
    GeneralResult<List<ShopDTO>> queryAllShop();

}
