package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.User;
import com.junli.system.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private SessionDAO sessionDAO;


    /**
     * @param page
     * @param user
     * @return
     */
    @RequiresPermissions("sys:menu:menu")
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<User> list(Page page, User user) {
        EntityWrapper<User> userEntityWrapper = new EntityWrapper<User>();
        return userService.selectPage(page, userEntityWrapper);
    }

    /**
     * @param user
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(User user) {
        boolean b = userService.insert(user);
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
        boolean b = userService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param user
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(User user) {
        boolean b = userService.updateById(user);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

