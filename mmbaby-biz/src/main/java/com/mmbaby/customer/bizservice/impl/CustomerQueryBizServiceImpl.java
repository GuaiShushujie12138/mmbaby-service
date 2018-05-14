package com.mmbaby.customer.bizservice.impl;

import com.mmbaby.base.exception.QueryArgsWrongException;
import com.mmbaby.customer.bizservice.ICustomerQueryBizService;
import com.mmbaby.customer.domainservice.ICustomerDomainService;
import com.mmbaby.customer.dto.domain.CustomerDTO;
import com.mmbaby.customer.dto.query.CustomerQueryDTO;
import com.site.lookup.util.StringUtils;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 15:58
 */

@Log4j
public class CustomerQueryBizServiceImpl implements ICustomerQueryBizService {

    @Autowired
    private ICustomerDomainService customerDomainService;

    /**
     * 根据客户名称查询客户信息
     *
     * @param customerName
     * @return
     */
    @Override
    public CustomerQueryDTO queryCustomerByName(String customerName) {
        // 检查参数
        checkCustomerName(customerName);

        CustomerDTO customerDTO = customerDomainService.queryCustomerByName(customerName);

        return buildCustomerQueryDTO(customerDTO);
    }


    /**
     * 根据注册手机号查询客户信息
     *
     * @param mobile
     * @return
     */
    @Override
    public CustomerQueryDTO queryCustomerByMobile(String mobile) {
        // 检查参数
        checkMobile(mobile);

        CustomerDTO customerDTO = customerDomainService.queryCustomerByMobile(mobile);

        return buildCustomerQueryDTO(customerDTO);
    }

    /**
     * 检查手机参数
     * @param mobile
     */
    private void checkMobile(String mobile) {
        if (StringUtils.isEmpty(mobile)) {
            throw new QueryArgsWrongException("mobile 参数不能为空");
        }
    }

    /**
     * 检查客户名称参数
     * @param customerName
     */
    private void checkCustomerName(String customerName) {
        if (StringUtils.isEmpty(customerName)) {
            throw new QueryArgsWrongException("customerName 参数不能为空");
        }
    }

    /**
     * 构造CustomerQueryDTO 对象
     * @param customerDTO
     * @return
     */
    private CustomerQueryDTO buildCustomerQueryDTO(CustomerDTO customerDTO) {
        CustomerQueryDTO customerQueryDTO = new CustomerQueryDTO();

        BeanUtils.copyProperties(customerDTO, customerQueryDTO);

        return customerQueryDTO;
    }
}
