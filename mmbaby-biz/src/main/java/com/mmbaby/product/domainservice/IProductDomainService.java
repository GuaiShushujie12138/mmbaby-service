package com.mmbaby.product.domainservice;

import com.mmbaby.product.dto.domain.ProductDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:22
 */
public interface IProductDomainService {

    /**
     * 保存或者更新商品
     * @param productDTO
     * @return
     */
    ProductDTO saveSelective(ProductDTO productDTO);

}
