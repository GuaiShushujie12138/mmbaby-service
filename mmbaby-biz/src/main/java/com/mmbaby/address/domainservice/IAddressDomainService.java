package com.mmbaby.address.domainservice;

import com.mmbaby.address.dto.domain.AddressDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/10 at 20:09
 */
public interface IAddressDomainService {

    /**
     * 保存或者更新收货地址
     * @param addressDTO
     * @return
     */
    AddressDTO saveSelective(AddressDTO addressDTO);

}
