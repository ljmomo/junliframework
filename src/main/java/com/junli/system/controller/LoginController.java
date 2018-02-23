package com.junli.system.controller;

import com.junli.common.utils.MD5Utils;
import com.junli.common.utils.R;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lijun
 * @create 2017-12-01 11:22
 */
@Controller
public class LoginController {
    /**
     * 做登录
     * @param username 用户名
     * @param password  密码
     * @return
     */

    @PostMapping("/login")
    @ResponseBody
    public  R loginDo(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return R.ok();
        } catch (AuthenticationException e) {
            return R.error("用户或密码错误");
        }
    }

    /**
     * 跳转登录页
     * @return
     */
    @GetMapping("/login")
    public  String login() {
        return "login";
    }
}
