package com.mmbaby.customer.bizservice.impl;

import com.mmbaby.base.exception.SaveFailedException;
import com.mmbaby.base.util.security.MD5Util;
import com.mmbaby.customer.bizservice.ICustomerSubmitBizService;
import com.mmbaby.customer.domainservice.ICustomerDomainService;
import com.mmbaby.customer.dto.domain.CustomerDTO;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;
import com.site.lookup.util.StringUtils;
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
        // 检查注册参数
        checkRegisterArgs(customerSubmitDTO);

        // 判断客户名称和手机号有无被注册
        checkIfRegisted(customerSubmitDTO);

        CustomerDTO customerDTO = buildCustomerDTO(customerSubmitDTO);

        return customerDomainService.saveSelective(customerDTO);
    }

    /**
     * 更新客户信息
     *
     * @param customerSubmitDTO
     */
    @Override
    public CustomerDTO updateCustomerInfo(
            CustomerSubmitDTO customerSubmitDTO) {
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
        CustomerDTO customerDTO = customerDomainService.
                queryCustomerByName(customerSubmitDTO.getCustomerName());

        // 进行客户名称和密码的匹配
        boolean isCorrect = isCorrect(customerDTO, customerSubmitDTO);

        if (isCorrect) {
            return customerDTO;
        }

        return null;
    }

    /**
     * 检查注册提交参数
     * @param customerSubmitDTO
     */
    private void checkRegisterArgs(CustomerSubmitDTO customerSubmitDTO) {
        if (customerSubmitDTO == null) {
            throw new SaveFailedException("参数错误");
        }

        if (StringUtils.isEmpty(customerSubmitDTO.getCustomerName())) {
            throw new SaveFailedException("客户名称不可为空");
        }

        if (StringUtils.isEmpty(customerSubmitDTO.getPassword())) {
            throw new SaveFailedException("客户密码不可为空");
        }

        if (StringUtils.isEmpty(customerSubmitDTO.getMobile())) {
            throw new SaveFailedException("客户注册手机号不可为空");
        }
    }

    /**
     * 判断用户的客户名和手机是否被注册
     * @param customerSubmitDTO
     */
    private void checkIfRegisted(CustomerSubmitDTO customerSubmitDTO) {
        CustomerDTO customerDTO = customerDomainService.queryCustomerByName(customerSubmitDTO.getCustomerName());
        if (customerDTO != null
                && customerSubmitDTO.getCustomerName().equals(customerDTO.getCustomerName())) {
            throw new SaveFailedException("该客户名已经被注册");
        }

        CustomerDTO customerDTO2 = customerDomainService.queryCustomerByMobile(customerSubmitDTO.getMobile());
        if (customerDTO2 != null
                && customerSubmitDTO.getMobile().equals(customerDTO2.getMobile())) {
            throw new SaveFailedException("该手机号已经被注册");
        }
    }

    /**
     * 进行登陆的验证
     * @param customerDTO
     * @param customerSubmitDTO
     * @return
     */
    private boolean isCorrect(CustomerDTO customerDTO,
                              CustomerSubmitDTO customerSubmitDTO) {
        if (customerDTO == null
                || MD5Util.getMD5ofStr(customerSubmitDTO.getPassword())
                .equals(customerDTO.getPassword())) {
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

        // 密码加密
        customerDTO.setPassword(MD5Util.getMD5ofStr(customerDTO.getPassword()));

        return customerDTO;
    }
}
