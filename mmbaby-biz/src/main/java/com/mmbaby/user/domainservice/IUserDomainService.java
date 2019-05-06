package com.mmbaby.user.domainservice;

import com.mmbaby.user.dto.domain.UserDTO;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/11 at 11:42
 */
public interface IUserDomainService {

    /**
     * 保存或者更新用户信息
     * @param userDTO
     * @return
     */
    UserDTO saveSelective(UserDTO userDTO);

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     */
    UserDTO queryUserByName(String userName);
}
