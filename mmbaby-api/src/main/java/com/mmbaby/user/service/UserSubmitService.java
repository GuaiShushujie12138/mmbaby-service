package com.mmbaby.user.service;

import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.user.dto.domain.UserDTO;
import com.mmbaby.user.dto.submitbiz.UserSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 15:41
 */
public interface UserSubmitService {

    /**
     * 用户登陆
     * @param userSubmitDTO
     * @return
     */
    GeneralResult<UserDTO> login(UserSubmitDTO userSubmitDTO);

    /**
     * 添加用户
     * @param userSubmitDTO
     * @return
     */
    GeneralResult<UserDTO> addUser(UserSubmitDTO userSubmitDTO);

    /**
     * 更新用户信息
     * @param userSubmitDTO
     * @return
     */
    GeneralResult<UserDTO> updateUserInfo(UserSubmitDTO userSubmitDTO);
}
