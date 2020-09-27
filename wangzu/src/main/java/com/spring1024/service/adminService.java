package com.spring1024.service;

import com.spring1024.bean.admin;
import com.spring1024.bean.menu;
import com.spring1024.bean.role;

import java.util.List;

public interface adminService {
    /**
    *   管理员登陆验证
    *
     */
    admin logincheck(admin admin);
    /**
     *   查询所有管理员
     *
     */
    List<admin> queryAllAdmin();
    /**
     *   通过管理员名字查询管理员
     *
     */
    admin findAdminByName(String adminName);

   role fingAdminRole(int rid);

   List<menu> findAdminMenu(int rid);

   void addAdmin(admin admin);
}
