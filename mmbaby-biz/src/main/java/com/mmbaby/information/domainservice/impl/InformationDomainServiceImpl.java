package com.mmbaby.information.domainservice.impl;

import com.dianping.pigeon.util.CollectionUtils;
import com.google.common.collect.Lists;
import com.mmbaby.information.domainservice.IInformationDomainService;
import com.mmbaby.information.dto.domain.InformationDTO;
import com.mmbaby.information.entity.InformationEntity;
import com.mmbaby.information.entity.InformationEntityExample;
import com.mmbaby.information.mapper.InformationEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:06
 */

@Service
public class InformationDomainServiceImpl implements IInformationDomainService {

    @Autowired
    private InformationEntityMapper informationEntityMapper;

    /**
     * 保存或者更新资讯
     *
     * @param customerDTO
     * @return
     */
    @Override
    public InformationDTO saveSelective(InformationDTO customerDTO) {

        if (customerDTO == null) {
            return customerDTO;
        }

        InformationEntity informationEntity = dto2Entity(customerDTO);

        if (informationEntity.getId() == null) {
            informationEntityMapper.insertSelective(informationEntity);
        } else {
            informationEntityMapper.updateByPrimaryKeySelective(informationEntity);
        }

        return entity2Dto(informationEntity);
    }

    /**
     * 查询最近的一条资讯
     *
     * @return
     */
    @Override
    public InformationDTO queryLastInformation() {
        InformationEntityExample example = new InformationEntityExample();
        example.setOrderByClause("create_time desc");

        List<InformationEntity> informationEntityList = informationEntityMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(informationEntityList)) {
            return entity2Dto(informationEntityList.get(0));
        }

        return null;
    }

    /**
     * 查询资讯列表
     *
     * @return
     */
    @Override
    public List<InformationDTO> queryInformationList() {
        InformationEntityExample example = new InformationEntityExample();
        example.setOrderByClause("create_time desc");

        List<InformationEntity> informationEntityList = informationEntityMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(informationEntityList)) {
            return entity2Dto(informationEntityList);
        }

        return null;
    }

    private List<InformationDTO> entity2Dto(List<InformationEntity> informationEntityList) {
        List<InformationDTO> informationList = Lists.newArrayList();

        for (InformationEntity informationEntity : informationEntityList) {
            informationList.add(entity2Dto(informationEntity));
        }

        return informationList;
    }

    private InformationDTO entity2Dto(InformationEntity entity) {

        if (null == entity) {
            return null;
        }
        InformationDTO dto = new InformationDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private InformationDTO entity2Dto(InformationEntity entity, InformationDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private InformationEntity dto2Entity(InformationDTO dto) {

        if (null == dto) {
            return null;
        }
        InformationEntity entity = new InformationEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private InformationEntity dto2Entity(InformationDTO dto, InformationEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
