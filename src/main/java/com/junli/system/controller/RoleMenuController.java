package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.RoleMenu;
import com.junli.system.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色与菜单对应关系 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/roleMenu")
public class RoleMenuController {


    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * @param page
     * @param roleMenu
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<RoleMenu> list(Page page, RoleMenu roleMenu) {
        EntityWrapper<RoleMenu> roleMenuEntityWrapper = new EntityWrapper<RoleMenu>();
        return roleMenuService.selectPage(page, roleMenuEntityWrapper);
    }

    /**
     * @param roleMenu
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(RoleMenu roleMenu) {
        boolean b = roleMenuService.insert(roleMenu);
        if (b) {
            return R.ok();
        } else {
            return R.error("保存失败！");
        }
    }

    /**
     * @param id
     * @return
     */
    @PostMapping(value = "/del/{id}")
    @ResponseBody
    public R del(@PathVariable("id") Long id) {
        boolean b = roleMenuService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param roleMenu
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(RoleMenu roleMenu) {
        boolean b = roleMenuService.updateById(roleMenu);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

