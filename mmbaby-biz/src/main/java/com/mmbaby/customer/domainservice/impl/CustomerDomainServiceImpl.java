package com.mmbaby.customer.domainservice.impl;

import com.mmbaby.customer.domainservice.ICustomerDomainService;
import com.mmbaby.customer.dto.domain.CustomerDTO;
import com.mmbaby.customer.entity.CustomerEntity;
import com.mmbaby.customer.mapper.CustomerEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 10:35
 */
public class CustomerDomainServiceImpl implements ICustomerDomainService {

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    /**
     * 保存或者更新客户信息
     *
     * @param customerDTO
     * @return
     */
    @Override
    public CustomerDTO saveSelective(CustomerDTO customerDTO) {

        if (customerDTO == null) {
            return customerDTO;
        }

        CustomerEntity customerEntity = dto2Entity(customerDTO);

        if (customerEntity.getId() == null) {
            customerEntityMapper.insertSelective(customerEntity);
        } else {
            customerEntityMapper.updateByPrimaryKeySelective(customerEntity);
        }

        return entity2Dto(customerEntity);
    }

    private CustomerDTO entity2Dto(CustomerEntity entity) {

        if (null == entity) {
            return null;
        }
        CustomerDTO dto = new CustomerDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private CustomerDTO entity2Dto(CustomerEntity entity, CustomerDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private CustomerEntity dto2Entity(CustomerDTO dto) {

        if (null == dto) {
            return null;
        }
        CustomerEntity entity = new CustomerEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private CustomerEntity dto2Entity(CustomerDTO dto, CustomerEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
