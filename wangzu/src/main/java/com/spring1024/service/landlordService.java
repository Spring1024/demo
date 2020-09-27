package com.spring1024.service;

import com.spring1024.bean.house;
import com.spring1024.bean.landlord;
import com.spring1024.bean.menu;
import com.spring1024.bean.role;
import com.spring1024.util.PageBean;

import java.util.List;

public interface landlordService {
    /**
     * 查询所有房东信息
     *
     * @param pc
     * @return
     */
    List<landlord> queryLandlord();

    /**
     * 通过房屋Id查询房东信息
     */
    landlord queryByLid(String lid);

    /**
     * 房东登录
     */
    landlord logincheck(landlord landlord);

    /**
     * 查询房东名下的房屋
     */
    List<house> queryHousesByLid(String lid, Integer pageNum,Integer limit);

    Integer getCountByDate(String ldate);

    Integer deleteLandlordHouseID(String hid);

    landlord findLandlordByName(String lname);

    role findLandlordRole(Integer rid);

    List<menu> findLandlordMenu(Integer rid);

    Integer deleteLandlordHByLid(String lid);

    void addLandlord(landlord landlord);
}
