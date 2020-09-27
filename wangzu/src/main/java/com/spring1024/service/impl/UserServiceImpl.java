package com.spring1024.service.impl;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.spring1024.bean.collect;
import com.spring1024.bean.house;
import com.spring1024.bean.user;
import com.spring1024.dao.userDao;
import com.spring1024.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring1024.util.UuidBean;
import com.spring1024.bean.BQueryVo;
import com.spring1024.service.userService;

@Service
@Transactional
public class UserServiceImpl implements userService {
	
	@Autowired
	private userDao userdao;
	
	@Override
	public void addUser(user user) {
		// TODO Auto-generated method stub
		String uid=UuidBean.GetUuid();
		user.setUid(uid);
		userdao.addUser(user);
	}

	@Override
	public user findUserByName(String username) {
		return userdao.findUserByName(username);
	}

	@Override
	public void updateUser(user user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
	}

	@Override
	public void deleteUserByUid(String uid) {
		// TODO Auto-generated method stub
		userdao.deleteUserByUid(uid);
	}

	@Override
	public user logincheck(user user) {
		user=userdao.logincheck(user);
		if(user==null) {
			System.out.println("用户不存在！");
		}
		return user;
	}

	@Override
	public void checkutel(String utel) {
		Integer count = userdao.checkutel(utel);
		if(count > 0){
			throw new RuntimeException("该号码已经注册过啦，不能再次注册呢，去登陆吧");
		}
		
	}

	@Override
	public List<user> queryUsers() {

		List<user> users = userdao.queryUsers();
		return users;
	}

	@Override
	public void addCollect(collect cl) {
		userdao.addCollect(cl);
	}

	@Override
	public PageBean<house> queryCollect(String uid) {
		Integer ps =4;

		
		//得到条件下的总记录数
		Integer tr = userdao.queryCountCollect(uid);
		if(tr == null){
			tr = 1;
		}
		List<house> hs = userdao.queryCollect(uid);
		
		PageBean<house> pb = new PageBean<>();
		
		pb.setBeanList(hs);
		pb.setPs(ps);
		pb.setTr(tr);
		
		return pb;
	}

	@Override
	public Integer getCountByDate(String udate) {
		return userdao.getCountByDate(udate);
	}

	@Override
	public String isHaveHouseByUid(collect cl) {
		return userdao.isHaveHouseByUid(cl);
	}


}
