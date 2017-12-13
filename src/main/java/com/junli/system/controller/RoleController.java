package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.Role;
import com.junli.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/role")
public class RoleController {


    @Autowired
    private RoleService roleService;

    /**
     * @param page
     * @param role
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<Role> list(Page page, Role role) {
        EntityWrapper<Role> roleEntityWrapper = new EntityWrapper<Role>();
        return roleService.selectPage(page, roleEntityWrapper);
    }

    /**
     * @param role
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(Role role) {
        boolean b = roleService.insert(role);
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
        boolean b = roleService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param role
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(Role role) {
        boolean b = roleService.updateById(role);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

