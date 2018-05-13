package com.mmbaby.customer.domainservice;

import com.mmbaby.customer.dto.domain.CustomerDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 10:28
 */
public interface ICustomerDomainService {

    /**
     * 保存或者更新客户信息
     * @param customerDTO
     * @return
     */
    CustomerDTO saveSelective(CustomerDTO customerDTO);

    /**
     * 根据客户名称查询客户信息
     * @param customerName
     * @return
     */
    CustomerDTO queryCustomerByName(String customerName);
}
