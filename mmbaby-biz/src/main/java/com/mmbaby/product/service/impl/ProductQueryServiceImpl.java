package com.mmbaby.product.service.impl;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.product.bizservice.IProductQueryBizService;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.query.ProductQueryDTO;
import com.mmbaby.product.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:17
 */

@Service("productQueryService")
public class ProductQueryServiceImpl implements ProductQueryService {

    @Autowired
    private IProductQueryBizService productQueryBizService;

    /**
     * 根据商品id查询商品详情
     *
     * @param productId
     * @return
     */
    @Override
    public GeneralResult<ProductDTO> queryProductById(Integer productId) {
        ProductDTO productDTO = productQueryBizService.queryProductById(productId);

        return new GeneralResult<>(productDTO);
    }

    /**
     * 多重条件查询商品list
     *
     * @param productQueryDTO
     * @return
     */
    @Override
    public GeneralResult<List<ProductDTO>> queryProductList(ProductQueryDTO productQueryDTO) {
        List<ProductDTO> productList = productQueryBizService.queryProductList(productQueryDTO);

        return new GeneralResult<>(productList);
    }
}
