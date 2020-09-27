package com.spring1024.service.impl;

import com.spring1024.bean.admin;
import com.spring1024.bean.menu;
import com.spring1024.bean.role;
import com.spring1024.dao.adminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring1024.service.adminService;

import java.util.List;

@Service
public class adminServiceImpl implements adminService {

	@Autowired
	private adminDao adminDao;
	@Override
	public admin logincheck(admin admin) {
		admin=adminDao.logincheck(admin);
		if(admin==null) {
			System.out.println("用户不存在！");
		}
		return admin;
	}

	@Override
	public List<admin> queryAllAdmin() {
		List<admin> adminList=adminDao.queryAllAdmin();
		return adminList;
	}

	@Override
	public admin findAdminByName(String adminName) {
		return adminDao.findAdminByName(adminName);
	}

	@Override
	public role fingAdminRole(int rid) {
		return adminDao.findAdminRole(rid);
	}

	@Override
	public List<menu> findAdminMenu(int rid) {
		return adminDao.findAdminMenu(rid);
	}

	@Override
	public void addAdmin(admin admin) {
		adminDao.addAdmin(admin);
	}

}
