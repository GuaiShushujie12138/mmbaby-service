package com.mmbaby.region.domainservice;

import com.mmbaby.region.dto.domain.RegionDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:31
 */
public interface IRegionDomainService {

    /**
     * 保存或者更新地点
     * @param regionDTO
     * @return
     */
    RegionDTO saveSelective(RegionDTO regionDTO);

}
