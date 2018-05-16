package com.mmbaby.address.service;

import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.base.util.GeneralResult;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 9:19
 */
public interface AddressQueryService {

    /**
     * 根据客户id 查询出该客户名下的收货地址
     * @param customerId
     * @return
     */
    GeneralResult<List<AddressDTO>> queryAddressListByCustomerId(Integer customerId);

}
