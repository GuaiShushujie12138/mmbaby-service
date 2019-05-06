package com.mmbaby.address.bizservice;

import com.mmbaby.address.dto.domain.AddressDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 9:22
 */
public interface IAddressQueryBizService {

    /**
     * 根据客户id 查询出该客户名下的收货地址
     * @param customerId
     * @return
     */
    List<AddressDTO> queryAddressListByCustomerId(Integer customerId);

    /**
     * 根据addressId 查询地址信息
     * @param addressId
     * @return
     */
    AddressDTO queryByAddressId(Integer addressId);
}
