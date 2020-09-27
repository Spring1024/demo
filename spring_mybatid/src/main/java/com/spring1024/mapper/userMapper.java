package com.spring1024.mapper;

import com.spring1024.bean.userbean;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface userMapper {
    //通过id查找用户
    @Cacheable(cacheNames = {"user","user"},key = "#id")
    public userbean getUserById(Integer id);
    //查询所有用户

    public List<userbean> getAllUser();
    //删除指定用户

    public void deleteUserById(int id);
    //添加用户

    public void insertUser(userbean userbean);
    //更新用户信息
    @CacheEvict
    public void updateUser(userbean userbean);
}
