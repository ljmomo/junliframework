package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.File;
import com.junli.system.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文件上传 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/file")
public class FileController {


    @Autowired
    private FileService fileService;

    /**
     * @param page
     * @param file
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<File> list(Page page, File file) {
        EntityWrapper<File> fileEntityWrapper = new EntityWrapper<File>();
        return fileService.selectPage(page, fileEntityWrapper);
    }

    /**
     * @param file
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(File file) {
        boolean b = fileService.insert(file);
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
        boolean b = fileService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param file
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(File file) {
        boolean b = fileService.updateById(file);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

