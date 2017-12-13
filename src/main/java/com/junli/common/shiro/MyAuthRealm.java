package com.junli.common.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.junli.system.entity.User;
import com.junli.system.service.MenuService;
import com.junli.system.service.RoleService;
import com.junli.system.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


/**
 * @author lijun
 * @create 2017-12-01 9:59
 */
public class MyAuthRealm extends AuthorizingRealm {


    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user=(User) principalCollection.fromRealm(getName()).iterator().next();//获取
        List<String> perms = menuService.listUserPerms(user.getUserId());
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
         info.addRoles(roleService.listRoles(user.getUserId()));
        //将权限放入shiro中.
        info.addStringPermissions(perms);
        return info;
    }

    /**
     * 认证.登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());

        User user = userService.selectOne(new EntityWrapper<User>().eq("username",username));
        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
       // 密码错误
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        // 账号锁定
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }

        //放入shiro.调用CredentialsMatcher检验密码
        return new SimpleAuthenticationInfo(user,password,getName());

    }


}
