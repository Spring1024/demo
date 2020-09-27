package com.spring1024.dao;

import com.alibaba.fastjson.JSONObject;
import com.spring1024.bean.BQueryVo;
import com.spring1024.bean.collect;
import com.spring1024.bean.house;
import com.spring1024.bean.user;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface userDao {
    user logincheck(user user);

    user findUserByName(String username);

    void addUser(user user);

    void updateUser(user user);

    void deleteUserByUid(String uid);

    /**
     * 校验电话号码是否被注册
     *
     * @param utele
     * @return
     */
    int checkutel(String utele);

    /**
     * 查询用户总数
     *
     * @param vo
     * @return
     */
    Integer queryUsersTotal(BQueryVo vo);

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

    List<house> queryCollect(String uid);

    Integer queryCountCollect(String uid);

    Integer getCountByDate(String udate);

    String isHaveHouseByUid(collect cl);
}
