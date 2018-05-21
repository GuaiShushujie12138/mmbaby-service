package com.mmbaby.product.domainservice;

import com.mmbaby.base.util.PageUtil;
import com.mmbaby.product.dto.domain.ProductDTO;

import java.util.List;

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

    /**
     * 根据productId 查询商品
     * @param productId
     * @return
     */
    ProductDTO queryProductById(Integer productId);

    /**
     * 根据多重查询条件查询商品list
     * @param productDTO
     * @return
     */
    List<ProductDTO> queryProductList(ProductDTO productDTO, PageUtil page);
}
