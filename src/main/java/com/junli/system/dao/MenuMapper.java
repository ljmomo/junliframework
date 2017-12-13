package com.junli.system.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.junli.system.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查询权限
     * @param userId
     * @return
     */
   List<String> listUserPerms(@Param("userId") Long userId);

}
