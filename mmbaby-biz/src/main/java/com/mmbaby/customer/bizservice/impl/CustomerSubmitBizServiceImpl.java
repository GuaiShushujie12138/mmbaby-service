package com.mmbaby.customer.bizservice.impl;

import com.mmbaby.base.util.security.MD5Util;
import com.mmbaby.customer.bizservice.ICustomerSubmitBizService;
import com.mmbaby.customer.domainservice.ICustomerDomainService;
import com.mmbaby.customer.dto.domain.CustomerDTO;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 10:45
 *
 * 主要的核心业务service
 */

@Service
public class CustomerSubmitBizServiceImpl implements ICustomerSubmitBizService {

    @Autowired
    private ICustomerDomainService customerDomainService;

    /**
     * 提交客户注册信息
     *
     * @param customerSubmitDTO
     */
    @Override
    public CustomerDTO submit(CustomerSubmitDTO customerSubmitDTO) {
        CustomerDTO customerDTO = buildCustomerDTO(customerSubmitDTO);

        return customerDomainService.saveSelective(customerDTO);
    }

    /**
     * 更新客户信息
     *
     * @param customerSubmitDTO
     */
    @Override
    public CustomerDTO updateCustomerInfo(CustomerSubmitDTO customerSubmitDTO) {
        CustomerDTO customerDTO = buildCustomerDTO(customerSubmitDTO);

        // update 更新时间
        customerDTO.setUpdateTime(new Date());

        return customerDomainService.saveSelective(customerDTO);
    }

    /**
     * 客户登陆
     *
     * @param customerSubmitDTO
     * @return
     */
    @Override
    public CustomerDTO login(CustomerSubmitDTO customerSubmitDTO) {
        // 根据客户登陆的名字查询对应的数据库客户信息
        CustomerDTO customerDTO = customerDomainService.queryCustomerByName(customerSubmitDTO.getCustomerName());

        // 进行客户名称和密码的匹配
        boolean isCorrect = isCorrect(customerDTO, customerSubmitDTO);

        if (isCorrect) {
            return customerDTO;
        }

        return new CustomerDTO();
    }

    /**
     * 进行登陆的验证
     * @param customerDTO
     * @param customerSubmitDTO
     * @return
     */
    private boolean isCorrect(CustomerDTO customerDTO, CustomerSubmitDTO customerSubmitDTO) {
        if (customerDTO == null
                || MD5Util.getMD5ofStr(customerSubmitDTO.getPassword()).equals(customerDTO.getPassword())) {
            return false;
        }

        return true;
    }

    /**
     * 构造CustomerDTO对象
     * @param customerSubmitDTO
     * @return
     */
    private CustomerDTO buildCustomerDTO(CustomerSubmitDTO customerSubmitDTO) {
        CustomerDTO customerDTO = new CustomerDTO();

        BeanUtils.copyProperties(customerSubmitDTO, customerDTO);

        return customerDTO;
    }
}
