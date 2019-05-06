package com.mmbaby.information.bizservice.impl;

import com.mmbaby.information.bizservice.IInformationQueryBizService;
import com.mmbaby.information.domainservice.IInformationDomainService;
import com.mmbaby.information.dto.domain.InformationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 20:56
 */

@Service
public class InformationQueryBizServiceImpl implements IInformationQueryBizService {

    @Autowired
    private IInformationDomainService informationDomainService;

    /**
     * 查询最近的一条资讯
     *
     * @return
     */
    @Override
    public InformationDTO queryLastInformation() {
        return informationDomainService.queryLastInformation();
    }

    /**
     * 查询资讯列表
     *
     * @return
     */
    @Override
    public List<InformationDTO> queryInformationList() {
        return informationDomainService.queryInformationList();
    }
}
