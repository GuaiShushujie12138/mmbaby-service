package com.mmbaby.customer.service.impl;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;
import com.mmbaby.customer.service.CustomerSubmitService;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/12 at 10:44
 */

@Service("customerSubmitService")
public class CustomerSubmitServiceImpl implements CustomerSubmitService {

    /**
     * 提交用户注册信息
     *
     * @param customerSubmitDTO
     * @return
     */
    @Override
    public GeneralResult submit(CustomerSubmitDTO customerSubmitDTO) {
        return null;
    }
}
