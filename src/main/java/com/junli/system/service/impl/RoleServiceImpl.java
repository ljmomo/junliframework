package com.junli.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.junli.system.dao.RoleMapper;
import com.junli.system.entity.Role;
import com.junli.system.entity.UserRole;
import com.junli.system.service.RoleService;
import com.junli.system.service.UserRoleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    /**
     * @param userId
     */
    @Override
    public List<String> listRoles(Long userId) {
        List<UserRole> userRoles = userRoleService.selectList(new EntityWrapper<UserRole>().eq("user_id", userId));
        List<Long> roleIds = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
        return roleService.selectBatchIds(roleIds).stream().filter(role-> StringUtils.isNotBlank(role.getRoleSign())).map(role ->role.getRoleSign()).collect(Collectors.toList());
    }
}
