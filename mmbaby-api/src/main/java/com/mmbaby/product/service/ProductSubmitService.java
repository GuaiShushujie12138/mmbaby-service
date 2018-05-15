package com.mmbaby.product.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.submitbiz.ProductSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:06
 */
public interface ProductSubmitService {

    /**
     * 新增商品
     * @param productSubmitDTO
     * @return
     */
    GeneralResult<ProductDTO> saveProduct(ProductSubmitDTO productSubmitDTO);

    /**
     * 更新商品信息
     * @param productSubmitDTO
     * @return
     */
    GeneralResult<ProductDTO> updateProductInfo(ProductSubmitDTO productSubmitDTO);
}
