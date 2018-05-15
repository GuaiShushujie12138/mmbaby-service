package com.mmbaby.product.service.impl;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.product.bizservice.IProductSubmitBizService;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.submitbiz.ProductSubmitDTO;
import com.mmbaby.product.service.ProductSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:18
 */

@Service("productSubmitService")
public class ProductSubmitServiceImpl implements ProductSubmitService {

    @Autowired
    private IProductSubmitBizService productSubmitBizService;

    /**
     * 新增商品
     *
     * @param productSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<ProductDTO> saveProduct(ProductSubmitDTO productSubmitDTO) {
        ProductDTO productDTO = productSubmitBizService.saveProduct(productSubmitDTO);

        return new GeneralResult<>(productDTO);
    }

    /**
     * 更新商品信息
     *
     * @param productSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<ProductDTO> updateProductInfo(ProductSubmitDTO productSubmitDTO) {
        ProductDTO productDTO = productSubmitBizService.updateProductInfo(productSubmitDTO);

        return new GeneralResult<>(productDTO);
    }
}
