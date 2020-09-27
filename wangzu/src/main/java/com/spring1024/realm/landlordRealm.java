package com.spring1024.realm;

import com.spring1024.bean.admin;
import com.spring1024.bean.landlord;
import com.spring1024.bean.menu;
import com.spring1024.bean.role;
import com.spring1024.service.adminService;
import com.spring1024.service.landlordService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;

public class landlordRealm extends AuthorizingRealm {
    @Resource
    private landlordService landlordService;

    /**
     * 授权当前用户
     * shiro什么时候会进入doGetAuthorizationInfo?
     *      * 1、subject.hasRole(“admin”) 或 subject.isPermitted(“admin”)：自己去调用这个是否有什么角色或者是否有什么权限的时候；
     *      * 2、@RequiresRoles("admin") ：在方法上加注解的时候；
     *      * 3、[@shiro.hasPermission name = "admin"][/@shiro.hasPermission]：在页面上加shiro标签的时候，
     *      * 即进这个页面的时候扫描到有这个标签的时候。
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String name=principals.getPrimaryPrincipal().toString();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        landlord landlord=landlordService.findLandlordByName(name);
        if(landlord!=null) {

            role role = landlordService.findLandlordRole(landlord.getRid());
            if (role != null) {
                //添加角色
                info.addRole(role.getRole());
                //添加权限
                List<menu> menuList = landlordService.findLandlordMenu(role.getRid());
                for (menu menu : menuList) {
                    info.addStringPermission(menu.getMname()); // 添加权限
                }
            }
        }
        return info;
    }

    /**
     * 验证当前用户
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (token.getPrincipal() == null) {
            return null;
        }
        String name=token.getPrincipal().toString();
        landlord landlord= landlordService.findLandlordByName(name);
        //AuthenticationInfo对象是以char[]类型接收密码，如果数据库存储的密码时sting，需要提前转化，否则报错
        char[] chars=landlord.getLpwd().toCharArray();
        if(landlord!=null){
            AuthenticationInfo authenticationInfo =
                    new SimpleAuthenticationInfo(landlord.getLname(),
                            chars,"landlord") ;
            return authenticationInfo;
        }
        else{
            return null;
        }
    }
}
