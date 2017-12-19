package com.junli.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijun
 * @create 2017-12-19 11:26
 */
@Controller
public class IndexController {
    @RequestMapping("index")
    public  String index(){
        return "index";
    }
}
