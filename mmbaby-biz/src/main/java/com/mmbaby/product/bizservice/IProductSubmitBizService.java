package com.mmbaby.product.bizservice;

import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.submitbiz.ProductSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:12
 */
public interface IProductSubmitBizService {

    /**
     * 新增商品
     * @param productSubmitDTO
     * @return
     */
    ProductDTO saveProduct(ProductSubmitDTO productSubmitDTO);

    /**
     * 更新商品信息
     * @param productSubmitDTO
     * @return
     */
    ProductDTO updateProductInfo(ProductSubmitDTO productSubmitDTO);

}
