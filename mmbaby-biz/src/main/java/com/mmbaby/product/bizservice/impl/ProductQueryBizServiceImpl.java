package com.mmbaby.product.bizservice.impl;

import com.mmbaby.base.exception.SaveFailedException;
import com.mmbaby.base.util.PageUtil;
import com.mmbaby.product.bizservice.IProductQueryBizService;
import com.mmbaby.product.domainservice.IProductDomainService;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.dto.query.ProductQueryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/15 at 19:15
 */

@Service
public class ProductQueryBizServiceImpl implements IProductQueryBizService {

    @Autowired
    private IProductDomainService productDomainService;

    /**
     * 根据商品id查询商品详情
     *
     * @param productId
     * @return
     */
    @Override
    public ProductDTO queryProductById(Integer productId) {
        // 参数校验
        checkArgs(productId);

        return productDomainService.queryProductById(productId);
    }


    /**
     * 多重条件查询商品list
     *
     * @param productQueryDTO
     * @return
     */
    @Override
    public List<ProductDTO> queryProductList(ProductQueryDTO productQueryDTO, PageUtil page) {
        // 参数校验
        checkArgs(productQueryDTO);

        ProductDTO productDTO = buildProductDTO(productQueryDTO);

        return productDomainService.queryProductList(productDTO, page);
    }

    /**
     * 构造ProductDTO 对象
     * @param productQueryDTO
     * @return
     */
    private ProductDTO buildProductDTO(ProductQueryDTO productQueryDTO) {
        ProductDTO productDTO = new ProductDTO();

        BeanUtils.copyProperties(productQueryDTO, productDTO);

        return productDTO;
    }

    /**
     * 检查参数
     * @param productQueryDTO
     */
    private void checkArgs(ProductQueryDTO productQueryDTO) {
        if (productQueryDTO == null) {
            throw new SaveFailedException("查询条件productQueryDTO不能为空!");
        }
    }

    /**
     * 检查参数
     * @param productId
     */
    private void checkArgs(Integer productId) {
        if (productId == null) {
            throw new SaveFailedException("productId不能为空!");
        }
    }
}
