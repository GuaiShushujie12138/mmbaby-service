package com.mmbaby.information.bizservice.impl;

import com.mmbaby.information.bizservice.IInformationSubmitBizService;
import com.mmbaby.information.domainservice.IInformationDomainService;
import com.mmbaby.information.dto.domain.InformationDTO;
import com.mmbaby.information.dto.submitbiz.InformationSubmitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 21:19
 */

@Service
public class InformationSubmitBizServiceImpl implements IInformationSubmitBizService {

    @Autowired
    private IInformationDomainService informationDomainService;

    /**
     * 保存资讯信息
     *
     * @param informationSubmitDTO
     * @return
     */
    @Override
    public InformationDTO saveInformation(InformationSubmitDTO informationSubmitDTO) {
        InformationDTO informationDTO = buildInformationDTO(informationSubmitDTO);

        return informationDomainService.saveSelective(informationDTO);
    }

    /**
     * 构造InformationDTO 对象
     * @param informationSubmitDTO
     * @return
     */
    private InformationDTO buildInformationDTO(InformationSubmitDTO informationSubmitDTO) {
        InformationDTO informationDTO = new InformationDTO();

        BeanUtils.copyProperties(informationSubmitDTO, informationDTO);

        return informationDTO;
    }
}
