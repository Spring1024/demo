package com.spring1024.test;

import com.spring1024.bean.userbean;
import com.spring1024.mapper.userMapperImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userMapperImpl userMapper=context.getBean("userMapper", userMapperImpl.class);
        List<userbean> userList= userMapper.getAllUser();
        for (userbean u:userList) {
            System.out.println(u);
        }
    }
}
