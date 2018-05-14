package com.mmbaby.user.service.impl;

import com.mmbaby.base.util.ErrorResult;
import com.mmbaby.base.util.GeneralResult;
import com.mmbaby.customer.dto.submitbiz.CustomerSubmitDTO;
import com.mmbaby.user.bizservice.IUserSubmitBizService;
import com.mmbaby.user.dto.domain.UserDTO;
import com.mmbaby.user.dto.submitbiz.UserSubmitDTO;
import com.mmbaby.user.service.UserSubmitService;
import com.site.lookup.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Wanghui Fu
 * Created by Guaishushu on 2018/5/13 at 15:43
 */

@Service("userSubmitService")
public class UserSubmitServiceImpl implements UserSubmitService {

    @Autowired
    private IUserSubmitBizService userSubmitBizService;

    /**
     * 用户登陆
     *
     * @param userSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<UserDTO> login(UserSubmitDTO userSubmitDTO) {
        GeneralResult generalResult = checkLoginArgs(userSubmitDTO);

        if (!generalResult.isSuccess()) {
            return new ErrorResult(generalResult.getMsg());
        }

        UserDTO userDTO = userSubmitBizService.login(userSubmitDTO);

        return new GeneralResult(userDTO);
    }

    /**
     * 添加用户
     *
     * @param userSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<UserDTO> addUser(UserSubmitDTO userSubmitDTO) {


        return new GeneralResult();
    }

    /**
     * 更新用户信息
     *
     * @param userSubmitDTO
     * @return
     */
    @Override
    public GeneralResult<UserDTO> updateUserInfo(UserSubmitDTO userSubmitDTO) {
        return null;
    }

    /**
     * 检查登陆参数
     * @param userSubmitDTO
     * @return
     */
    private GeneralResult checkLoginArgs(UserSubmitDTO userSubmitDTO) {

        if (userSubmitDTO == null
                || StringUtils.isEmpty(userSubmitDTO.getUserName())
                || StringUtils.isEmpty(userSubmitDTO.getPassword())) {
            return new ErrorResult("登陆参数错误,请检查后再次提交登陆!");
        }

        return new GeneralResult();
    }
}
