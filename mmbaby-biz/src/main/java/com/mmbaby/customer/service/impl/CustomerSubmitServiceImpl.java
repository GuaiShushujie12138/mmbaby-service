package com.mmbaby.customer.service.impl;

import com.mmbaby.base.util.ErrorResult;
import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.customer.bizservice.ICustomerSubmitBizService;
import com.mmbaby.customer.dto.domain.CustomerDTO;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;
import com.mmbaby.customer.service.CustomerSubmitService;
import com.site.lookup.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/12 at 10:44
 */

@Service("customerSubmitService")
public class CustomerSubmitServiceImpl implements CustomerSubmitService {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerSubmitServiceImpl.class);

    @Autowired
    private ICustomerSubmitBizService customerSubmitBizService;

    /**
     * 提交用户注册信息
     *
     * @param customerSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<CustomerDTO> submit(CustomerSubmitDTO customerSubmitDTO) {
        CustomerDTO customerDTO = customerSubmitBizService.submit(customerSubmitDTO);

        if (customerDTO == null) {

        }

        return new GeneralResult(customerDTO);
    }

    /**
     * 更新客户信息
     *
     * @param customerSubmitDTO
     * @return
     */
    @Override
    public GeneralResult updateCustomerInfo(CustomerSubmitDTO customerSubmitDTO) {
        CustomerDTO customerDTO = customerSubmitBizService.updateCustomerInfo(customerSubmitDTO);

        return new GeneralResult(customerDTO);
    }

    /**
     * 客户登陆
     *
     * @param customerSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<CustomerDTO> login(CustomerSubmitDTO customerSubmitDTO) {
        GeneralResult generalResult = checkLoginArgs(customerSubmitDTO);

        if (!generalResult.isSuccess()) {
            return new ErrorResult(generalResult.getMsg());
        }

        CustomerDTO customerDTO = customerSubmitBizService.login(customerSubmitDTO);
        if (customerDTO == null) {
            return new ErrorResult("用户名或者密码错误");
        }

        return new GeneralResult(customerDTO);
    }

    /**
     * 检查登陆参数
     * @param customerSubmitDTO
     * @return
     */
    private GeneralResult checkLoginArgs(CustomerSubmitDTO customerSubmitDTO) {

        if (customerSubmitDTO == null
                || StringUtils.isEmpty(customerSubmitDTO.getCustomerName())
                || StringUtils.isEmpty(customerSubmitDTO.getPassword())) {
            return new ErrorResult("登陆参数错误,请检查后再次提交登陆!");
        }

        return new GeneralResult();
    }

}
