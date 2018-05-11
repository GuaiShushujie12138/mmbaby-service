package com.mmbaby.information.domainservice.impl;

import com.mmbaby.information.domainservice.IInformationDomainService;
import com.mmbaby.information.dto.domain.InformationDTO;
import com.mmbaby.information.entity.InformationEntity;
import com.mmbaby.information.mapper.InformationEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:06
 */
public class InformationDomainServiceImpl implements IInformationDomainService {

    @Autowired
    private InformationEntityMapper informationEntityMapper;

    /**
     * 保存或者更新资讯
     *
     * @param customerDTO
     * @return
     */
    @Override
    public InformationDTO saveSelective(InformationDTO customerDTO) {

        if (customerDTO == null) {
            return customerDTO;
        }

        InformationEntity informationEntity = dto2Entity(customerDTO);

        if (informationEntity.getId() == null) {
            informationEntityMapper.insertSelective(informationEntity);
        } else {
            informationEntityMapper.updateByPrimaryKeySelective(informationEntity);
        }

        return entity2Dto(informationEntity);
    }

    private InformationDTO entity2Dto(InformationEntity entity) {

        if (null == entity) {
            return null;
        }
        InformationDTO dto = new InformationDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private InformationDTO entity2Dto(InformationEntity entity, InformationDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private InformationEntity dto2Entity(InformationDTO dto) {

        if (null == dto) {
            return null;
        }
        InformationEntity entity = new InformationEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private InformationEntity dto2Entity(InformationDTO dto, InformationEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
