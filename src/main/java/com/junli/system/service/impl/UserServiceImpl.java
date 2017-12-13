package com.junli.system.service.impl;

import com.junli.system.entity.User;
import com.junli.system.dao.UserMapper;
import com.junli.system.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
