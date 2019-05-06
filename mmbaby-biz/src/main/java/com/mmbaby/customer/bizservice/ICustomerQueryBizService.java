package com.mmbaby.customer.bizservice;

import com.mmbaby.customer.dto.query.CustomerQueryDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/14 at 15:57
 */
public interface ICustomerQueryBizService {

    /**
     * 根据客户名称查询客户信息
     * @param customerName
     * @return
     */
    CustomerQueryDTO queryCustomerByName(String customerName);

    /**
     * 根据注册手机号查询客户信息
     * @param mobile
     * @return
     */
    CustomerQueryDTO queryCustomerByMobile(String mobile);

}
