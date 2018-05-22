package com.mmbaby.address.bizservice.impl;

import com.mmbaby.address.bizservice.IAddressQueryBizService;
import com.mmbaby.address.domainservice.IAddressDomainService;
import com.mmbaby.address.dto.domain.AddressDTO;
import com.mmbaby.base.exception.QueryArgsWrongException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/16 at 9:23
 */

@Service
public class AddressQueryBizServiceImpl implements IAddressQueryBizService {

    @Autowired
    private IAddressDomainService addressDomainService;

    /**
     * 根据客户id 查询出该客户名下的收货地址
     *
     * @param customerId
     * @return
     */
    @Override
    public List<AddressDTO> queryAddressListByCustomerId(Integer customerId) {
        // 参数检查
        checkArgs(customerId);

        return addressDomainService.queryAddressListByCustomerId(customerId);
    }

    /**
     * 根据addressId 查询地址信息
     *
     * @param addressId
     * @return
     */
    @Override
    public AddressDTO queryByAddressId(Integer addressId) {
        return addressDomainService.queryByAddressId(addressId);
    }

    /**
     * 检查参数
     * @param customerId
     */
    private void checkArgs(Integer customerId) {
        if (customerId == null) {
            throw new QueryArgsWrongException("customerId 不能为空");
        }
    }
}
