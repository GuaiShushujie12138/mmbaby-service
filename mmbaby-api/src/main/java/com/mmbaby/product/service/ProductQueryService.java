package com.mmbaby.product.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.base.util.PageUtil;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.query.ProductQueryDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 18:58
 */
public interface ProductQueryService {

    /**
     * 根据商品id查询商品详情
     * @param productId
     * @return
     */
    GeneralResult<ProductDTO> queryProductById(Integer productId);

    /**
     * 多重条件查询商品list, 分页
     * @param productQueryDTO
     * @return
     */
    GeneralResult<List<ProductDTO>> queryProductList(ProductQueryDTO productQueryDTO, PageUtil page);

    /**
     * 根据关键字搜索商品
     * @param pageUtil
     * @return
     */
    GeneralResult<List<ProductDTO>> queryByKeyWord(PageUtil pageUtil);
}
