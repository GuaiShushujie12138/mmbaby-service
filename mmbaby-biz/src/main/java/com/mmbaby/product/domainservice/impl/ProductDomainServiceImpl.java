package com.mmbaby.product.domainservice.impl;

import com.mmbaby.product.domainservice.IProductDomainService;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.entity.ProductEntity;
import com.mmbaby.product.mapper.ProductEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:28
 */

@Service
public class ProductDomainServiceImpl implements IProductDomainService {

    @Autowired
    private ProductEntityMapper productEntityMapper;

    /**
     * 保存或者更新商品
     *
     * @param productDTO
     * @return
     */
    @Override
    public ProductDTO saveSelective(ProductDTO productDTO) {

        if (productDTO == null) {
            return productDTO;
        }

        ProductEntity productEntity = dto2Entity(productDTO);

        if (productEntity.getId() == null) {
            productEntityMapper.insertSelective(productEntity);
        } else {
            productEntityMapper.updateByPrimaryKeySelective(productEntity);
        }

        return entity2Dto(productEntity);
    }

    private ProductDTO entity2Dto(ProductEntity entity) {

        if (null == entity) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private ProductDTO entity2Dto(ProductEntity entity, ProductDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private ProductEntity dto2Entity(ProductDTO dto) {

        if (null == dto) {
            return null;
        }
        ProductEntity entity = new ProductEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private ProductEntity dto2Entity(ProductDTO dto, ProductEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}

