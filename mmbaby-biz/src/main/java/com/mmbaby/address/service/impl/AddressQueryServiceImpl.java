package com.mmbaby.address.service.impl;

import com.mmbaby.address.bizservice.IAddressQueryBizService;
import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.service.AddressQueryService;
import com.mmbaby.base.util.GeneralResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 9:21
 */

@Service("addressQueryService")
public class AddressQueryServiceImpl implements AddressQueryService {

    @Autowired
    private IAddressQueryBizService addressQueryBizService;

    /**
     * 根据客户id 查询出该客户名下的收货地址
     *
     * @param customerId
     * @return
     */
    @Override
    public GeneralResult<List<AddressDTO>> queryAddressListByCustomerId(Integer customerId) {
        List<AddressDTO> addressList = addressQueryBizService.queryAddressListByCustomerId(customerId);

        return new GeneralResult<>(addressList);
    }
}
