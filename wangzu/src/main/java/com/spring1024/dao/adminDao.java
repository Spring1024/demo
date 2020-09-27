package com.spring1024.dao;

import com.spring1024.bean.admin;
import com.spring1024.bean.menu;
import com.spring1024.bean.role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface adminDao {
	admin logincheck(admin admin);

	List<admin> queryAllAdmin();

	admin findAdminByName(String adminName);

	role findAdminRole(int rid);

	List<menu> findAdminMenu(int rid);

	void addAdmin(admin admin);
}
