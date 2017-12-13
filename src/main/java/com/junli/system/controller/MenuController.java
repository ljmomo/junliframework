package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.Menu;
import com.junli.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;

    /**
     * @param page
     * @param menu
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<Menu> list(Page page, Menu menu) {
        EntityWrapper<Menu> menuEntityWrapper = new EntityWrapper<Menu>();
        return menuService.selectPage(page, menuEntityWrapper);
    }

    /**
     * @param menu
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(Menu menu) {
        boolean b = menuService.insert(menu);
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
        boolean b = menuService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param menu
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(Menu menu) {
        boolean b = menuService.updateById(menu);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

