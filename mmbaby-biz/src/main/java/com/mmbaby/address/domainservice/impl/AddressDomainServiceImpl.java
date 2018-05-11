package com.mmbaby.address.domainservice.impl;

import com.mmbaby.address.domainservice.IAddressDomainService;
import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.entity.AddressEntity;
import com.mmbaby.address.mapper.AddressEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/10 at 23:04
 */

@Service
public class AddressDomainServiceImpl implements IAddressDomainService {

    @Autowired
    private AddressEntityMapper addressEntityMapper;

    /**
     * 保存或者更新收货地址
     *
     * @param addressDTO
     * @return
     */
    @Override
    public AddressDTO saveSelective(AddressDTO addressDTO) {

        if (addressDTO == null) {
            return addressDTO;
        }

        AddressEntity addressEntity = dto2Entity(addressDTO);

        if (addressEntity.getId() == null) {
            addressEntityMapper.insertSelective(addressEntity);
        } else {
            addressEntityMapper.updateByPrimaryKeySelective(addressEntity);
        }

        return entity2Dto(addressEntity);
    }

    private AddressDTO entity2Dto(AddressEntity entity) {

        if (null == entity) {
            return null;
        }
        AddressDTO dto = new AddressDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private AddressDTO entity2Dto(AddressEntity entity, AddressDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private AddressEntity dto2Entity(AddressDTO dto) {

        if (null == dto) {
            return null;
        }
        AddressEntity entity = new AddressEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private AddressEntity dto2Entity(AddressDTO dto, AddressEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
