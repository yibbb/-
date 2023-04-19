package com.meishitanfang.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.meishitanfang.dto.LoginFormDTO;
import com.meishitanfang.dto.Result;
import com.meishitanfang.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);
}
