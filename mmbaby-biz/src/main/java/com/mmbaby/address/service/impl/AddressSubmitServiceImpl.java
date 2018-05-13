package com.mmbaby.address.service.impl;

import com.mmbaby.address.bizservice.IAddressSubmitBizService;
import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.dto.submitbiz.AddressSubmitDTO;
import com.mmbaby.address.service.AddressSubmitService;
import com.mmbaby.base.util.GeneralResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 19:58
 */

@Service
public class AddressSubmitServiceImpl implements AddressSubmitService {

    @Autowired
    private IAddressSubmitBizService addressSubmitBizService;

    /**
     * 新增收货地址
     *
     * @param addressSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<AddressDTO> saveAddress(AddressSubmitDTO addressSubmitDTO) {
        AddressDTO addressDTO = addressSubmitBizService.saveAddress(addressSubmitDTO);

        return new GeneralResult(addressDTO);
    }

    /**
     * 更新收货地址 (设置默认地址)
     *
     * @param addressSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<AddressDTO> updateAddressInfo(AddressSubmitDTO addressSubmitDTO) {
        return null;
    }
}
