package com.mmbaby.information.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.information.dto.domain.InformationDTO;
import com.mmbaby.information.dto.submitbiz.InformationSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 21:16
 */
public interface InformationSubmitService {

    /**
     * 保存资讯信息
     * @param informationSubmitDTO
     * @return
     */
    GeneralResult<InformationDTO> saveInfomation(InformationSubmitDTO informationSubmitDTO);

}
