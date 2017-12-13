package com.junli.system.service.impl;

import com.junli.system.entity.UserRole;
import com.junli.system.dao.UserRoleMapper;
import com.junli.system.service.UserRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
