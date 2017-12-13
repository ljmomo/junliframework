package com.junli.system.service;

import com.junli.system.entity.Role;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
public interface RoleService extends IService<Role> {
    /**
     *
     * @param userId
     */
   List<String> listRoles(Long userId);
}
