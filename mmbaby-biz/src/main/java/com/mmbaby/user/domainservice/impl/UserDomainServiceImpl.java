package com.mmbaby.user.domainservice.impl;

import com.dianping.pigeon.util.CollectionUtils;
import com.mmbaby.user.domainservice.IUserDomainService;
import com.mmbaby.user.dto.domain.UserDTO;
import com.mmbaby.user.entity.UserEntity;
import com.mmbaby.user.entity.UserEntityExample;
import com.mmbaby.user.mapper.UserEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:57
 */

@Service
public class UserDomainServiceImpl implements IUserDomainService {

    @Autowired
    private UserEntityMapper userEntityMapper;

    /**
     * 保存或者更新用户信息
     *
     * @param userDTO
     * @return
     */
    @Override
    public UserDTO saveSelective(UserDTO userDTO) {

        if (userDTO == null) {
            return userDTO;
        }

        UserEntity userEntity = dto2Entity(userDTO);

        if (userEntity.getId() == null) {
            userEntityMapper.insertSelective(userEntity);
        } else {
            userEntityMapper.updateByPrimaryKeySelective(userEntity);
        }

        return entity2Dto(userEntity);
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public UserDTO queryUserByName(String userName) {
        UserDTO userDTO = new UserDTO();

        UserEntityExample example = new UserEntityExample();
        UserEntityExample.Criteria criteria = example.createCriteria();

        criteria.andUserNameEqualTo(userName);

        List<UserEntity> userEntityList = userEntityMapper.selectByExample(example);

        if (!CollectionUtils.isEmpty(userEntityList)) {
            userDTO = entity2Dto(userEntityList.get(0));
        }

        return userDTO;
    }

    private UserDTO entity2Dto(UserEntity entity) {

        if (null == entity) {
            return null;
        }
        UserDTO dto = new UserDTO();
        entity2Dto(entity, dto);

        return dto;
    }

    private UserDTO entity2Dto(UserEntity entity, UserDTO dto) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(entity, dto);

        return dto;
    }

    private UserEntity dto2Entity(UserDTO dto) {

        if (null == dto) {
            return null;
        }
        UserEntity entity = new UserEntity();
        dto2Entity(dto, entity);
        return entity;
    }

    private UserEntity dto2Entity(UserDTO dto, UserEntity entity) {

        if (null == entity || null == dto) {
            return null;
        }
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
