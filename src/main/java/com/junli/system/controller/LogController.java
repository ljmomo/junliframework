package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.Log;
import com.junli.system.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 系统日志 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/log")
public class LogController {


    @Autowired
    private LogService logService;

    /**
     * @param page
     * @param log
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<Log> list(Page page, Log log) {
        EntityWrapper<Log> logEntityWrapper = new EntityWrapper<Log>();
        return logService.selectPage(page, logEntityWrapper);
    }

    /**
     * @param log
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(Log log) {
        boolean b = logService.insert(log);
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
        boolean b = logService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param log
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(Log log) {
        boolean b = logService.updateById(log);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

