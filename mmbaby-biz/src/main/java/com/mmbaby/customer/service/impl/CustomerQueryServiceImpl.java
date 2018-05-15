package com.mmbaby.customer.service.impl;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.customer.bizservice.ICustomerQueryBizService;
import com.mmbaby.customer.dto.query.CustomerQueryDTO;
import com.mmbaby.customer.service.CustomerQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 15:52
 */

@Service("customerQueryService")
public class CustomerQueryServiceImpl implements CustomerQueryService {

    @Autowired
    private ICustomerQueryBizService customerQueryBizService;

    /**
     * 根据客户名称查询客户信息
     *
     * @param customerName
     * @return
     */
    @Override
    public GeneralResult<CustomerQueryDTO> queryCustomerByName(String customerName) {
        CustomerQueryDTO customerQueryDTO = customerQueryBizService.queryCustomerByName(customerName);

        return new GeneralResult<>(customerQueryDTO);
    }

    /**
     * 根据注册手机号查询客户信息
     *
     * @param mobile
     * @return
     */
    @Override
    public GeneralResult<CustomerQueryDTO> queryCustomerByMobile(String mobile) {
        CustomerQueryDTO customerQueryDTO = customerQueryBizService.queryCustomerByMobile(mobile);

        return new GeneralResult<>(customerQueryDTO);
    }
}
