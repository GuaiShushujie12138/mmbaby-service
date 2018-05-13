package com.mmbaby.address.bizservice.impl;

import com.mmbaby.address.bizservice.IAddressSubmitBizService;
import com.mmbaby.address.domainservice.IAddressDomainService;
import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.dto.submitbiz.AddressSubmitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 20:00
 */
public class AddressSubmitBizServiceImpl implements IAddressSubmitBizService {

    @Autowired
    private IAddressDomainService addressDomainService;

    /**
     * 保存收货地址
     *
     * @param addressSubmitDTO
     * @return
     */
    @Override
    public AddressDTO saveAddress(AddressSubmitDTO addressSubmitDTO) {
        AddressDTO addressDTO = buildAddressDTO(addressSubmitDTO);

        return addressDomainService.saveSelective(addressDTO);
    }

    /**
     * 更新收货地址 (设置默认)
     *
     * @param addressSubmitDTO
     * @return
     */
    @Override
    public AddressDTO updateAddressInfo(AddressSubmitDTO addressSubmitDTO) {
        return null;
    }

    /**
     * 构造AddressDTO对象
     * @param addressSubmitDTO
     * @return
     */
    private AddressDTO buildAddressDTO(AddressSubmitDTO addressSubmitDTO) {
        AddressDTO addressDTO = new AddressDTO();

        BeanUtils.copyProperties(addressSubmitDTO, addressDTO);

        return addressDTO;
    }
}
