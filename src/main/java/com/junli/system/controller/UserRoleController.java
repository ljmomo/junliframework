package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.UserRole;
import com.junli.system.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户与角色对应关系 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/userRole")
public class UserRoleController {


    @Autowired
    private UserRoleService userRoleService;

    /**
     * @param page
     * @param userRole
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<UserRole> list(Page page, UserRole userRole) {
        EntityWrapper<UserRole> userRoleEntityWrapper = new EntityWrapper<UserRole>();
        return userRoleService.selectPage(page, userRoleEntityWrapper);
    }

    /**
     * @param userRole
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(UserRole userRole) {
        boolean b = userRoleService.insert(userRole);
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
        boolean b = userRoleService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param userRole
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(UserRole userRole) {
        boolean b = userRoleService.updateById(userRole);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

