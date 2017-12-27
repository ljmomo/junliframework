package com.junli.system.controller;

import com.junli.common.utils.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lijun
 * @create 2017-12-01 11:22
 */
@Controller
@RequestMapping("")
public class LoginController {

    @PostMapping("/login")

    public  String login(String username, String password) {
        password = MD5Utils.encrypt(username, password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return  "index";
        } catch (AuthenticationException e) {
            return null;
        }
    }
}
