package com.mmbaby.user.bizservice;

import com.mmbaby.user.dto.domain.UserDTO;
import com.mmbaby.user.dto.submitbiz.UserSubmitDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 15:44
 */
public interface IUserSubmitBizService {

    /**
     * 用户登陆
     * @param userSubmitDTO
     * @return
     */
    UserDTO login(UserSubmitDTO userSubmitDTO);

    /**
     * 添加用户
     * @param userSubmitDTO
     * @return
     */
    UserDTO addUser(UserSubmitDTO userSubmitDTO);

    /**
     * 更新用户信息
     * @param userSubmitDTO
     * @return
     */
    UserDTO updateUserInfo(UserSubmitDTO userSubmitDTO);
}
