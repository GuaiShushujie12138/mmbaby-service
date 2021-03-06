package com.mmbaby.customer.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.customer.dto.query.CustomerQueryDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 15:47
 */
public interface CustomerQueryService {

    /**
     * 根据客户名称查询客户信息
     * @param customerName
     * @return
     */
    GeneralResult<CustomerQueryDTO> queryCustomerByName(String customerName);

    /**
     * 根据注册手机号查询客户信息
     * @param mobile
     * @return
     */
    GeneralResult<CustomerQueryDTO> queryCustomerByMobile(String mobile);
}
