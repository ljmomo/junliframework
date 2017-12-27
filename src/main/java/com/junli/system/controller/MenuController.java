package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.JSONUtils;
import com.junli.common.utils.MenuUtils;
import com.junli.common.utils.R;
import com.junli.system.entity.Menu;
import com.junli.system.service.MenuService;
import com.junli.system.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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



    /**
     * @param page
     * @param menu
     * @return
     */
    @GetMapping(value = "/listAll")
    @ResponseBody
    public List<Menu> listAll(Menu menu) throws Exception {
        List<Menu> menus = menuService.selectList(null);

        Map<Long, List<Menu>> collect = menus.stream().collect(Collectors.groupingBy(Menu::getParentId));
        Map<Boolean, List<Menu>> collect1 = menus.stream().collect(Collectors.partitioningBy(a -> a.getParentId() == 0 ? true : false));
        System.out.println(JSONUtils.obj2json(collect1));
        System.out.println(JSONUtils.obj2json(collect));
        List<MenuVo> menuVos = MenuUtils.progressMenu(menus);
        System.out.println("封装后的："+JSONUtils.obj2json(menuVos));
        return menus;
    }

}

