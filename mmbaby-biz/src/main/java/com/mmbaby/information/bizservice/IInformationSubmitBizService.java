package com.mmbaby.information.bizservice;

import com.mmbaby.information.dto.domain.InformationDTO;
import com.mmbaby.information.dto.submitbiz.InformationSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 21:18
 */
public interface IInformationSubmitBizService {

    /**
     * 保存资讯信息
     * @param informationSubmitDTO
     * @return
     */
    InformationDTO saveInformation(InformationSubmitDTO informationSubmitDTO);

}
