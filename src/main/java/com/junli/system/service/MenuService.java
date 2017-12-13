package com.junli.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.junli.system.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
public interface MenuService extends IService<Menu> {
    /**
     *
     * @param userId
     */
   List<String> listUserPerms(long userId);

}
