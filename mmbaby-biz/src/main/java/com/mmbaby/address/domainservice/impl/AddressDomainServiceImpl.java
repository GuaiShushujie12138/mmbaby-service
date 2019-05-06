package com.mmbaby.address.domainservice.impl;

import com.google.common.collect.Lists;
import com.mmbaby.address.domainservice.IAddressDomainService;
import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.entity.AddressEntity;
import com.mmbaby.address.entity.AddressEntityExample;
import com.mmbaby.address.mapper.AddressEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 根据客户id查询出所有的收货地址
     *
     * @param customerId
     * @return
     */
    @Override
    public List<AddressDTO> queryAddressListByCustomerId(Integer customerId) {
        List<AddressDTO> addressList = Lists.newArrayList();

        AddressEntityExample example = new AddressEntityExample();
        AddressEntityExample.Criteria criteria = example.createCriteria();

        criteria.andCustomerIdEqualTo(customerId);

        List<AddressEntity> addressEntityList = addressEntityMapper.selectByExample(example);

        return entity2Dto(addressEntityList);
    }

    /**
     * 根据addressId 查询地址信息
     *
     * @param addressId
     * @return
     */
    @Override
    public AddressDTO queryByAddressId(Integer addressId) {
        return entity2Dto(addressEntityMapper.selectByPrimaryKey(addressId));
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

    private List<AddressDTO> entity2Dto(List<AddressEntity> addressEntityList) {
        List<AddressDTO> addressList = Lists.newArrayList();

        for (AddressEntity addressEntity : addressEntityList) {
            addressList.add(entity2Dto(addressEntity));
        }

        return addressList;
    }
}
