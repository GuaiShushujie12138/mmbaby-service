package com.mmbaby.information.service.impl;

import com.dianping.pigeon.util.CollectionUtils;
import com.mmbaby.base.util.ErrorResult;
import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.information.bizservice.IInformationQueryBizService;
import com.mmbaby.information.dto.domain.InformationDTO;
import com.mmbaby.information.service.InformationQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/18 at 20:54
 */

@Service("informationQueryService")
public class InformationQueryServiceImpl implements InformationQueryService {

    @Autowired
    private IInformationQueryBizService informationQueryBizService;

    /**
     * 查询最近的一条资讯
     *
     * @return
     */
    @Override
    public GeneralResult<InformationDTO> queryLastInformation() {
        InformationDTO informationDTO = informationQueryBizService.queryLastInformation();

        if (informationDTO == null) {
            return new ErrorResult("没有该资讯");
        }

        return new GeneralResult<>(informationDTO);
    }

    /**
     * 查询资讯列表
     *
     * @return
     */
    @Override
    public GeneralResult<List<InformationDTO>> queryInformationList() {
        List<InformationDTO> informationList = informationQueryBizService.queryInformationList();

        if (CollectionUtils.isEmpty(informationList)) {
            return new ErrorResult("查询资讯列表失败，可能是还没有资讯");
        }

        return new GeneralResult<>(informationList);
    }
}
