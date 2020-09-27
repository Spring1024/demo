package com.spring1024.service;

import java.util.List;

import com.spring1024.bean.QueryVo;
import com.spring1024.bean.house;
import com.spring1024.bean.img;
import com.spring1024.util.PageBean;
import org.apache.ibatis.annotations.Param;

public interface houseService {
    /**
     * 查询房源
     * 首页展示
     * @return
     */
    List<house> queryHouses();

    /**
     * 查询所有房源
     * 后台获取
     * @return
     */
    List<house> queryAllHouses(@Param("page") Integer page,@Param("limit") Integer limit);

    /**
     * 查询相似房源
     *
     * @return
     */
    List<house> queryLikeHouses(house house);

    /**
     * 根据编码查询房子详细
     *
     * @param hid
     * @return
     */
    house queryHouseByHid(String hid);

    /**
     * 查找该该房子的所有图片
     *
     * @param hid
     * @return
     */
    List<img> getAllImgsByHid(String hid);

    /**
     * 按条件查询房源
     *
     * @param vo 查询条件实体
     * @param pc
     * @return
     */
    PageBean<house> queryHousesByCondition(QueryVo vo, int pc);

    /**
     * 删除房源的所有图片
     *
     * @param hid
     */
    void delAllImgsByHid(String hid);

    /**
     * 删除房源信息
     *
     * @param hid
     */
    void delHouseByHid(String hid);

    /**
     * 增加房源图片
     *
     * @param hid
     * @param newName
     */
    void addImgs(img img);

    /**
     * 更新房源信息
     *
     * @param house
     */
    void updateHouseByHid(house house);

    /**
     * 新增房源信息
     *
     * @param house
     */
    void addHouse(house house);

    /**
     * 查询点击量
     */
    int queryClick();

    /**
     * 查询点击量
     */
    int queryClickByLid(String lid);

    /**
     * 查询房屋数量
     */
    int queryCount();

    /**
     * 查询房东名下房屋数量
     */
    int queryCountByLid(String lid);

    Integer getCountByDate(String hdate);

    Integer delHouseByLid(String lid);
}
