package com.mmbaby.region.domainservice.impl;

import com.mmbaby.region.domainservice.IRegionDomainService;
import com.mmbaby.region.dto.domain.RegionDTO;
import com.mmbaby.region.entity.RegionEntity;
import com.mmbaby.region.mapper.RegionEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:34
 */

@Service
public class RegionDomainServiceImpl implements IRegionDomainService {

    @Autowired
    private RegionEntityMapper regionEntityMapper;

    /**
     * 保存或者更新地点
     *
     * @param regionDTO
     * @return
     */
    @Override
    public RegionDTO saveSelective(RegionDTO regionDTO) {

        if (regionDTO == null) {
            return regionDTO;
        }

        RegionEntity regionEntity = dto2Entity(regionDTO);

        if (regionEntity.getId() == null) {
            regionEntityMapper.insertSelective(regionEntity);
        } else {
            regionEntityMapper.updateByPrimaryKeySelective(regionEntity);
        }

        return entity2Dto(regionEntity);
    }

    private RegionDTO entity2Dto(RegionEntity entity) {

        if (null == entity) {
            return null;
        }
        RegionDTO dto = new RegionDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private RegionDTO entity2Dto(RegionEntity entity, RegionDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private RegionEntity dto2Entity(RegionDTO dto) {

        if (null == dto) {
            return null;
        }
        RegionEntity entity = new RegionEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private RegionEntity dto2Entity(RegionDTO dto, RegionEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}