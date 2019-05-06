package com.mmbaby.address.service;

import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.dto.submitbiz.AddressSubmitDTO;
import com.mmbaby.base.util.GeneralResult;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 19:56
 */
public interface AddressSubmitService {

    /**
     * 新增收货地址
     * @param addressSubmitDTO
     * @return
     */
    GeneralResult<AddressDTO> saveAddress(AddressSubmitDTO addressSubmitDTO);

    /**
     * 更新收货地址 (设置默认地址)
     * @param addressSubmitDTO
     * @return
     */
    GeneralResult<AddressDTO> updateAddressInfo(AddressSubmitDTO addressSubmitDTO);
}
