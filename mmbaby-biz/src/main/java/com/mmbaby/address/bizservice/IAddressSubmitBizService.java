package com.mmbaby.address.bizservice;

import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.dto.submitbiz.AddressSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 19:59
 */
public interface IAddressSubmitBizService {

    /**
     * 保存收货地址
     * @param addressSubmitDTO
     * @return
     */
    AddressDTO saveAddress(AddressSubmitDTO addressSubmitDTO);

    /**
     * 更新收货地址 (设置默认)
     * @param addressSubmitDTO
     * @return
     */
    AddressDTO updateAddressInfo(AddressSubmitDTO addressSubmitDTO);
}
