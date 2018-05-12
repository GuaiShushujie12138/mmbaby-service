package com.mmbaby.customer.service;

import com.mmbaby.base.util.GeneralResult;
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
    GeneralResult submit(CustomerSubmitDTO customerSubmitDTO);

}
