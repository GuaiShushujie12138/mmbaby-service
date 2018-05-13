package com.mmbaby.customer.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.customer.dto.domain.CustomerDTO;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/12 at 10:32
 */
public interface CustomerSubmitService {

    /**
     * 提交用户注册信息
     * @param customerSubmitDTO
     * @return
     */
    GeneralResult<CustomerDTO> submit(CustomerSubmitDTO customerSubmitDTO);

    /**
     * 更新客户信息
     * @param customerSubmitDTO
     * @return
     */
    GeneralResult<CustomerDTO> updateCustomerInfo(CustomerSubmitDTO customerSubmitDTO);

    /**
     * 客户登陆
     * @param customerSubmitDTO
     * @return
     */
    GeneralResult<CustomerDTO> login(CustomerSubmitDTO customerSubmitDTO);
}
