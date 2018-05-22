package com.mmbaby.product.domainservice.impl;

import com.dianping.pigeon.util.CollectionUtils;
import com.google.common.collect.Lists;
import com.mmbaby.base.util.PageUtil;
import com.mmbaby.product.domainservice.IProductDomainService;
import com.mmbaby.product.dto.domain.ProductDTO;
import com.mmbaby.product.entity.ProductEntity;
import com.mmbaby.product.entity.ProductEntityExample;
import com.mmbaby.product.mapper.ProductEntityMapper;
import com.site.lookup.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据productId 查询商品
     *
     * @param productId
     * @return
     */
    @Override
    public ProductDTO queryProductById(Integer productId) {

        return entity2Dto(productEntityMapper.selectByPrimaryKey(productId));
    }

    /**
     * 根据多重查询条件查询商品list
     *
     * @param productDTO
     * @return
     */
    @Override
    public List<ProductDTO> queryProductList(ProductDTO productDTO, PageUtil page) {
        ProductEntityExample example = new ProductEntityExample();
        ProductEntityExample.Criteria criteria = example.createCriteria();

        // 设置查询条件
        setQueryConditions(criteria, productDTO);

        // 设置分页条件
        example.setPage(page);

        // 设置排序条件
        if (page != null
                && !StringUtils.isEmpty(page.getSort())) {
            example.setOrderByClause(page.getSort());
        }

        List<ProductEntity> productEntityList = productEntityMapper.selectByExample(example);

        return entity2Dto(productEntityList);
    }

    /**
     * 根据关键字搜索商品
     *
     * @param pageUtil
     * @return
     */
    @Override
    public List<ProductDTO> queryByKeyWord(PageUtil pageUtil) {
        return entity2Dto(productEntityMapper.queryByKeyWord(pageUtil));
    }

    /**
     * 设置查询条件
     * @param criteria
     * @param productDTO
     */
    private void setQueryConditions(ProductEntityExample.Criteria criteria, ProductDTO productDTO) {
        // 热卖条件
        if (productDTO.getHot() != null) {
            criteria.andHotEqualTo(productDTO.getHot());
        }

        // 小分类条件
        if (productDTO.getCategory() != null) {
            criteria.andCategoryEqualTo(productDTO.getCategory());
        }

        // 价格区间条件
        if (productDTO.getPriceRegion() != null) {
            criteria.andPriceRegionEqualTo(productDTO.getPriceRegion());
        }

        // 商家条件
        if (productDTO.getShopId() != null) {
            criteria.andShopIdEqualTo(productDTO.getShopId());
        }

        // 年龄区间条件
        if (productDTO.getAgeRegion() != null) {
            criteria.andAgeRegionEqualTo(productDTO.getAgeRegion());
        }

        // 店长推荐条件
        if (productDTO.getRecommend() != null) {
            criteria.andRecommendEqualTo(productDTO.getRecommend());
        }

    }

    private List<ProductDTO> entity2Dto(List<ProductEntity> productEntityList) {
        List<ProductDTO> productList = Lists.newArrayList();

        for (ProductEntity productEntity : productEntityList) {
            productList.add(entity2Dto(productEntity));
        }

        return productList;
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

