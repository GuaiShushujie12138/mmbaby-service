package com.mmbaby.customer.bizservice;

import com.mmbaby.customer.dto.domain.CustomerDTO;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 10:40
 */
public interface ICustomerSubmitBizService {

    /**
     * 提交客户注册信息
     * @param customerSubmitDTO
     */
    CustomerDTO submit(CustomerSubmitDTO customerSubmitDTO);

    /**
     * 更新客户信息
     * @param customerSubmitDTO
     */
    CustomerDTO updateCustomerInfo(CustomerSubmitDTO customerSubmitDTO);

    /**
     * 客户登陆
     * @param customerSubmitDTO
     * @return
     */
    CustomerDTO login(CustomerSubmitDTO customerSubmitDTO);
}
