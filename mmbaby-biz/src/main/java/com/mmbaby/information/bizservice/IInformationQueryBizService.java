package com.mmbaby.information.bizservice;

import com.mmbaby.information.dto.domain.InformationDTO;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 20:55
 */
public interface IInformationQueryBizService {

    /**
     * 查询最近的一条资讯
     * @return
     */
    InformationDTO queryLastInformation();

    /**
     * 查询资讯列表
     * @return
     */
    List<InformationDTO> queryInformationList();

}
