package com.mmbaby.information.service.impl;

import com.mmbaby.base.util.ErrorResult;
import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.information.bizservice.IInformationSubmitBizService;
import com.mmbaby.information.dto.domain.InformationDTO;
import com.mmbaby.information.dto.submitbiz.InformationSubmitDTO;
import com.mmbaby.information.service.InformationSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 21:18
 */

@Service("informationSubmitService")
public class InformationSubmitServiceImpl implements InformationSubmitService {

    @Autowired
    private IInformationSubmitBizService informationSubmitBizService;

    /**
     * 保存资讯信息
     *
     * @param informationSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<InformationDTO> saveInfomation(InformationSubmitDTO informationSubmitDTO) {
        InformationDTO informationDTO = informationSubmitBizService.saveInformation(informationSubmitDTO);

        if (informationDTO == null) {
            return new ErrorResult("保存失败");
        }

        return new GeneralResult<>(informationDTO);
    }
}
