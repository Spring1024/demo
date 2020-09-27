package com.spring1024.dao;

import java.util.List;

import com.spring1024.bean.house;
import com.spring1024.bean.landlord;
import com.spring1024.bean.menu;
import com.spring1024.bean.role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface landlordDao {
	/**
	 * 查询用户总数
	 * @param vo
	 * @return
	 */
	Integer queryLandlordTotal();
	/**
	 * 查询所有用户
	 * @param vo
	 * @return
	 */
	List<landlord> queryLandlord();
	/**
	 * 查询房子所属
	 */
	landlord queryByLid(String lid);
	
	landlord logincheck(landlord landlord);
	
	/**
	 * 查询房东名下的总数量
	 * @param vo
	 * @return
	 */
	Integer getCountByLid(landlord landlord);

	/**
	 * 查询房东名下的所有房源
	 * @param vo
	 * @return
	 */
	List<house> queryHousesByLid(String lid, @Param("pageNum") Integer pageNum,@Param("limit") Integer limit);

	Integer getCountByDate(String ldate);

	Integer deleteLandlordHouseID(String hid);

	landlord findLandlordByName(String lname);

	role findLandlordRole(Integer rid);

	List<menu> findLandlordMenu(Integer rid);

	Integer deleteLandlordHByLid(String lid);

	void addLandlord(landlord landlord);
}
