package com.spring1024.service.impl;

import java.util.List;

import com.spring1024.bean.house;
import com.spring1024.bean.landlord;
import com.spring1024.bean.menu;
import com.spring1024.bean.role;
import com.spring1024.dao.landlordDao;
import com.spring1024.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring1024.util.PageEnum;
import com.spring1024.service.landlordService;


@Service
@Transactional
public class landlordServiceImpl implements landlordService {
	
	@Autowired
	private landlordDao landlordDao;
	@Override
	public List<landlord> queryLandlord() {
		List<landlord> landlords = landlordDao.queryLandlord();
		return landlords;
	}

	@Override
	public landlord queryByLid(String lid) {
		return landlordDao.queryByLid(lid);
	}

	@Override
	public landlord logincheck(landlord landlord) {
		landlord=landlordDao.logincheck(landlord);
		if(landlordDao.logincheck(landlord)==null) {
			System.out.println("该用户不存在！");
		}
		return landlord;
	}
	@Override
	public List<house> queryHousesByLid(String lid, Integer pageNum,Integer limit) {
		//查询条件下的所有房源
		return landlordDao.queryHousesByLid(lid,pageNum,limit);
	}

	@Override
	public Integer getCountByDate(String ldate) {
		return landlordDao.getCountByDate(ldate);
	}

	@Override
	public Integer deleteLandlordHouseID(String hid) {
		return landlordDao.deleteLandlordHouseID(hid);
	}

	@Override
	public landlord findLandlordByName(String lname) {
		return landlordDao.findLandlordByName(lname);
	}

	@Override
	public role findLandlordRole(Integer rid) {
		return landlordDao.findLandlordRole(rid);
	}

	@Override
	public List<menu> findLandlordMenu(Integer rid) {
		return landlordDao.findLandlordMenu(rid);
	}

	@Override
	public Integer deleteLandlordHByLid(String lid) {
		return landlordDao.deleteLandlordHByLid(lid);
	}

	@Override
	public void addLandlord(landlord landlord) {
		landlordDao.addLandlord(landlord);
	}

}
