package com.mmbaby.address.bizservice.impl;

import com.mmbaby.address.bizservice.IAddressSubmitBizService;
import com.mmbaby.address.domainservice.IAddressDomainService;
import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.address.dto.submitbiz.AddressSubmitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 20:00
 */

@Service
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

        // 默认地址的判断和设置
        buildDefaultAddress(addressSubmitDTO);

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
        AddressDTO addressDTO = buildAddressDTO(addressSubmitDTO);
        // 更新时间
        addressDTO.setUpdateTime(new Date());

        // 默认地址的判断和设置
        buildDefaultAddress(addressSubmitDTO);

        return addressDomainService.saveSelective(addressDTO);
    }

    /**
     * 默认地址的判断和设置
     * @param addressSubmitDTO
     */
    private void buildDefaultAddress(AddressSubmitDTO addressSubmitDTO) {
        // 判断是否将当前的地址设置为默认
        if (addressSubmitDTO.getDefaultAddress() != null
                && addressSubmitDTO.getDefaultAddress()) {
            // 将其他的地址的默认都设置为false
            setDefaultAddressFalse(addressSubmitDTO);
        }
    }

    /**
     * 设置默认地址为false
     * @param addressSubmitDTO
     */
    private void setDefaultAddressFalse(AddressSubmitDTO addressSubmitDTO) {
        // 根据customerId 查询出所有的地址
        List<AddressDTO> addressList =
                addressDomainService.queryAddressListByCustomerId(addressSubmitDTO.getCustomerId());

        // 将地址都设置为非默认，并且更新
        for (AddressDTO addressDTO : addressList) {
            if (!addressDTO.getId().equals(addressSubmitDTO.getId())) {
                addressDTO.setDefaultAddress(Boolean.FALSE);

                // 更新
                addressDomainService.saveSelective(addressDTO);
            }
        }
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
