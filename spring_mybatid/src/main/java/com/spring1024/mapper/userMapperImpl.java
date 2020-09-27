package com.spring1024.mapper;

import com.spring1024.bean.userbean;
import org.mybatis.spring.SqlSessionTemplate;
import java.util.List;
//整合mybatis+spring需要添加mapper的接口实现类。繁琐，但可以直接使用SqlSessionTemplate进行操作。
public class userMapperImpl implements userMapper{
    //原来由sqlSession操作，但是spring提供了SqlSessionTemplate,交由SqlSessionTemplate控制
    private SqlSessionTemplate sqlSession;
    //注入sqlSessionTemplate
    public void setSqlSession(SqlSessionTemplate sqlSession){
        this.sqlSession=sqlSession;
    }
    public userbean getUserById(Integer id) {
        userMapper userMapper=sqlSession.getMapper(userMapper.class);
        return userMapper.getUserById(id);
    }

    public List<userbean> getAllUser() {
        userMapper userMapper=sqlSession.getMapper(userMapper.class);
        return userMapper.getAllUser();
    }

    public void deleteUserById(int id) {

    }

    public void insertUser(userbean userbean) {

    }

    public void updateUser(userbean userbean) {

    }
}
