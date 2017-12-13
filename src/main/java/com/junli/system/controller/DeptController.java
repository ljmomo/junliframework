package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.Dept;
import com.junli.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门管理 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/dept")
public class DeptController {


    @Autowired
    private DeptService deptService;

    /**
     * @param page
     * @param dept
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<Dept> list(Page page, Dept dept) {
        EntityWrapper<Dept> deptEntityWrapper = new EntityWrapper<Dept>();
        return deptService.selectPage(page, deptEntityWrapper);
    }

    /**
     * @param dept
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(Dept dept) {
        boolean b = deptService.insert(dept);
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
        boolean b = deptService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param dept
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(Dept dept) {
        boolean b = deptService.updateById(dept);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

