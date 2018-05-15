package com.mmbaby.product.bizservice.impl;

import com.mmbaby.base.exception.SaveFailedException;
import com.mmbaby.product.bizservice.IProductSubmitBizService;
import com.mmbaby.product.domainservice.IProductDomainService;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.submitbiz.ProductSubmitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:16
 */

@Service
public class ProductSubmitBizServiceImpl implements IProductSubmitBizService {

    @Autowired
    private IProductDomainService productDomainService;

    /**
     * 新增商品
     *
     * @param productSubmitDTO
     * @return
     */
    @Override
    public ProductDTO saveProduct(ProductSubmitDTO productSubmitDTO) {
        // 参数校验
        checkArgs(productSubmitDTO);

        ProductDTO productDTO = buildProductDTO(productSubmitDTO);

        return productDomainService.saveSelective(productDTO);
    }

    /**
     * 更新商品信息
     *
     * @param productSubmitDTO
     * @return
     */
    @Override
    public ProductDTO updateProductInfo(ProductSubmitDTO productSubmitDTO) {
        // 参数校验
        checkArgs(productSubmitDTO);

        ProductDTO productDTO = buildProductDTO(productSubmitDTO);
        // 更新时间
        productDTO.setUpdateTime(new Date());

        return productDomainService.saveSelective(productDTO);
    }

    /**
     * 构造ProductDTO 对象
     * @param productSubmitDTO
     * @return
     */
    private ProductDTO buildProductDTO(ProductSubmitDTO productSubmitDTO) {
        ProductDTO productDTO = new ProductDTO();

        BeanUtils.copyProperties(productSubmitDTO, productDTO);

        return productDTO;
    }

    /**
     * 校验参数
     * @param productSubmitDTO
     */
    private void checkArgs(ProductSubmitDTO productSubmitDTO) {
        if (productSubmitDTO == null) {
            throw new SaveFailedException("productSubmitDTO 参数不可为空");
        }
    }
}
