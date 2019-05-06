package com.mmbaby.information.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.information.dto.domain.InformationDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 20:49
 */
public interface InformationQueryService {

    /**
     * 查询最近的一条资讯
     * @return
     */
    GeneralResult<InformationDTO> queryLastInformation();

    /**
     * 查询资讯列表
     * @return
     */
    GeneralResult<List<InformationDTO>> queryInformationList();
}
