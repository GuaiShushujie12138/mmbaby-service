package com.mmbaby.information.domainservice;


import com.mmbaby.information.dto.domain.InformationDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 10:39
 */
public interface IInformationDomainService {

    /**
     * 保存或者更新资讯
     * @param customerDTO
     * @return
     */
    InformationDTO saveSelective(InformationDTO customerDTO);

}
