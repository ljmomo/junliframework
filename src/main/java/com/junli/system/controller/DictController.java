package com.junli.system.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.junli.common.utils.R;
import com.junli.system.entity.Dict;
import com.junli.system.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 字典表 前端控制器
 * </p>
 *
 * @author lijun
 * @since 2017-11-30
 */
@Controller
@RequestMapping("/system/dict")
public class DictController {


    @Autowired
    private DictService dictService;

    /**
     * @param page
     * @param dict
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Page<Dict> list(Page page, Dict dict) {
        EntityWrapper<Dict> dictEntityWrapper = new EntityWrapper<Dict>();
        return dictService.selectPage(page, dictEntityWrapper);
    }

    /**
     * @param dict
     * @return
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public R save(Dict dict) {
        boolean b = dictService.insert(dict);
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
        boolean b = dictService.deleteById(id);
        if (b) {
            return R.ok();
        } else {
            return R.error("删除失败！");
        }
    }

    /**
     * @param dict
     * @return
     */
    @PostMapping(value = "/update")
    @ResponseBody
    public R update(Dict dict) {
        boolean b = dictService.updateById(dict);
        if (b) {
            return R.ok();
        } else {
            return R.error("修改失败！");
        }
    }

}

