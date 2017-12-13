package com.junli.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.junli.system.dao.MenuMapper;
import com.junli.system.entity.Menu;
import com.junli.system.service.MenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {


    @Autowired
    private MenuMapper menuMapper;

    /**
     * 查询权限
     * @param userId
     */
    @Override
    public List<String> listUserPerms(long userId) {
        List<String> perms = menuMapper.listUserPerms(userId);
        List<String> filterAfater = perms.stream().filter(s -> StringUtils.isNoneBlank(s)).collect(Collectors.toList());
        return filterAfater;
    }
}
