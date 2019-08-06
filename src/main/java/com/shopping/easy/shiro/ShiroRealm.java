package com.shopping.easy.shiro;

import com.shopping.easy.model.UserModel;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @Author:ZGP
 * @Desicription:实现AuthorizingRealm抽象类  身份认证doGetAuthenticationInfo  和授权doGetAuthorizationInfo
 * @Date:Created on 2018/7/9.
 * @Modified By:
 */
public class ShiroRealm extends AuthorizingRealm {

    @Autowired
    private com.shopping.easy.service.UserLoginService userLoginService;


    //授权，每一次访问都会授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserModel use = (UserModel) principals.getPrimaryPrincipal();//doGetAuthenticationInfo方法注入什么对象就转什么对象
        //查询角色权限
        UserModel user = userLoginService.findByAccount(use.getAccount());

        if(null == user){
            return null;
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        for (User role : user.getSysRoles()) {
//            authorizationInfo.addRole(role.getName());  // 添加角色
//            for (SysPermissionModel per : user.getSysPermissions()) {
//                authorizationInfo.addStringPermission(per.getCode());  // 添加具体权限
//            }
//        }
        return authorizationInfo;
    }

    //登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        String account = (String) token.getPrincipal(); // 获取用户登录账号
        UserModel userInfo = userLoginService.findByAccount(account);

        System.out.println("1");
        // 1). principal: 认证的实体信息. 可以是 username,也可以是数据表对应的用户的实体类对象,如果登录时需要返回用户的所有信息，则赋值用户对象
        Object principal = userInfo;
        // 2). credentials: 密码.
        Object credentials = userInfo.getPassword();
        // 3). realmName: 当前 realm 对象的唯一名字. 调用父类的 getName() 方法
        String realmName = super.getName();
        // 4). credentialsSalt: 盐值. 类型是ByteSource
        ByteSource credentialsSalt = ByteSource.Util.bytes(userInfo.getAccount());//将用户名作为盐
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);

        System.out.println("2");
        return info;
    }
}
