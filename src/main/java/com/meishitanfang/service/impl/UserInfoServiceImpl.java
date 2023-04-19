package com.meishitanfang.service.impl;

import com.meishitanfang.entity.UserInfo;
import com.meishitanfang.mapper.UserInfoMapper;
import com.meishitanfang.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
