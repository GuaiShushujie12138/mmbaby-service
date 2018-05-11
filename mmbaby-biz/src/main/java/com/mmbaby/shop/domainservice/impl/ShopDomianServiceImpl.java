package com.mmbaby.shop.domainservice.impl;

import com.mmbaby.shop.domainservice.IShopDomainService;
import com.mmbaby.shop.dto.domain.ShopDTO;
import com.mmbaby.shop.entity.ShopEntity;
import com.mmbaby.shop.mapper.ShopEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:40
 */

@Service
public class ShopDomianServiceImpl implements IShopDomainService {

    @Autowired
    private ShopEntityMapper shopEntityMapper;

    /**
     * 保存或者更新商家信息
     *
     * @param shopDTO
     * @return
     */
    @Override
    public ShopDTO saveSelective(ShopDTO shopDTO) {

        if (shopDTO == null) {
            return shopDTO;
        }

        ShopEntity shopEntity = dto2Entity(shopDTO);

        if (shopEntity.getId() == null) {
            shopEntityMapper.insertSelective(shopEntity);
        } else {
            shopEntityMapper.updateByPrimaryKeySelective(shopEntity);
        }

        return entity2Dto(shopEntity);
    }

    private ShopDTO entity2Dto(ShopEntity entity) {

        if (null == entity) {
            return null;
        }
        ShopDTO dto = new ShopDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private ShopDTO entity2Dto(ShopEntity entity, ShopDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private ShopEntity dto2Entity(ShopDTO dto) {

        if (null == dto) {
            return null;
        }
        ShopEntity entity = new ShopEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private ShopEntity dto2Entity(ShopDTO dto, ShopEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

}
