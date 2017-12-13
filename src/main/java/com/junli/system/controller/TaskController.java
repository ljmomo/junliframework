package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.Task;
import com.junli.system.service.TaskService;
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
@RequestMapping("/system/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    /**
     * @param page
     * @param task
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<Task> list(Page page, Task task) {
        EntityWrapper<Task> taskEntityWrapper = new EntityWrapper<Task>();
        return taskService.selectPage(page, taskEntityWrapper);
    }

    /**
     * @param task
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(Task task) {
        boolean b = taskService.insert(task);
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
        boolean b = taskService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param task
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(Task task) {
        boolean b = taskService.updateById(task);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

