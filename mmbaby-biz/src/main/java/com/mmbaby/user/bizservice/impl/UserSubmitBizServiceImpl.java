package com.mmbaby.user.bizservice.impl;

import com.mmbaby.base.exception.SaveFailedException;
import com.mmbaby.base.util.security.MD5Util;
import com.mmbaby.user.bizservice.IUserSubmitBizService;
import com.mmbaby.user.domainservice.IUserDomainService;
import com.mmbaby.user.dto.domain.UserDTO;
import com.mmbaby.user.dto.submitbiz.UserSubmitDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 15:46
 */

@Service
public class UserSubmitBizServiceImpl implements IUserSubmitBizService {

    @Autowired
    private IUserDomainService userDomainService;

    /**
     * 用户登陆
     *
     * @param userSubmitDTO
     * @return
     */
    @Override
    public UserDTO login(UserSubmitDTO userSubmitDTO) {
        // 根据用户名获取用户信息
        UserDTO userDTO = userDomainService.queryUserByName(userSubmitDTO.getUserName());

        // 进行用户名称和密码的匹配
        boolean isCorrect = isCorrect(userDTO, userSubmitDTO);

        if (isCorrect) {
            return userDTO;
        }

        return null;
    }

    /**
     * 添加用户
     *
     * @param userSubmitDTO
     * @return
     */
    @Override
    public UserDTO addUser(UserSubmitDTO userSubmitDTO) {
        UserDTO userDTO = buildUserDTO(userSubmitDTO);

        return userDomainService.saveSelective(userDTO);
    }

    /**
     * 更新用户信息
     *
     * @param userSubmitDTO
     * @return
     */
    @Override
    public UserDTO updateUserInfo(UserSubmitDTO userSubmitDTO) {
        // 更新用户参数校验
        checkUpdateArgs(userSubmitDTO);

        UserDTO userDTO = buildUserDTO(userSubmitDTO);

        userDTO.setUpdateTime(new Date());

        return userDomainService.saveSelective(userDTO);
    }

    /**
     * 更新用户的参数校验
     * @param userSubmitDTO
     */
    private void checkUpdateArgs(UserSubmitDTO userSubmitDTO) {
        if (userSubmitDTO == null) {
            throw new SaveFailedException("userSubmitDTO 对象不能为空");
        }

        if (userSubmitDTO.getId() == null) {
            throw new SaveFailedException("更新的id 不能为空");
        }
    }

    /**
     * 进行用户名称和密码的匹配
     * @param userDTO
     * @param userSubmitDTO
     * @return
     */
    private boolean isCorrect(UserDTO userDTO, UserSubmitDTO userSubmitDTO) {
        boolean isCorrect = true;

        if (userDTO == null
                || !MD5Util.string2MD5(userSubmitDTO.getPassword()).equals(userDTO.getPassword())) {
            isCorrect = false;
        }

        return isCorrect;
    }

    /**
     * 构造UserDTO对象
     * @param userSubmitDTO
     * @return
     */
    private UserDTO buildUserDTO(UserSubmitDTO userSubmitDTO) {
        UserDTO userDTO = new UserDTO();

        BeanUtils.copyProperties(userSubmitDTO, userDTO);

        return userDTO;
    }

}
