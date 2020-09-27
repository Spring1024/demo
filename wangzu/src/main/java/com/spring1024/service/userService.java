package com.spring1024.service;

import com.alibaba.fastjson.JSONObject;
import com.spring1024.bean.BQueryVo;
import com.spring1024.bean.collect;
import com.spring1024.bean.house;
import com.spring1024.bean.user;
import com.spring1024.util.PageBean;

import java.util.List;

public interface userService {
    user logincheck(user user);

    user findUserByName(String username);

    void addUser(user user);

    void updateUser(user user);

    void deleteUserByUid(String uid);

    void checkutel(String utel);

    /**
     * 查询所有用户
     *
     * @param vo
     * @return
     */
    List<user> queryUsers();

    /**
     * 添加收藏
     *
     * @param uid
     * @param hid
     */
    void addCollect(collect cl);

    PageBean<house> queryCollect(String uid);

    Integer getCountByDate(String udate);

    String isHaveHouseByUid(collect cl);
}
