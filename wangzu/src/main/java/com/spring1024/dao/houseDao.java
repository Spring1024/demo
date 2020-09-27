package com.spring1024.dao;

import com.spring1024.bean.QueryVo;
import com.spring1024.bean.house;
import com.spring1024.bean.img;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface houseDao {
    /**
     * 查找房源
     * 	首页展示
     * @return
     */
    List<house> queryHouses();
    /**
     * 查找所有房源
     *
     * @return
     */
    List<house> queryAllHouses(@Param("page") Integer page, @Param("limit") Integer limit);
    /**
     * 推荐房源
     * 详细页面展示
     */
    List<house> queryLikeHouses(house house);
    /**
     * 根据编码查询房子
     * @param hid
     * @return
     */
    house queryHouseByHid(String hid);

    /**
     * 查找该房子的所有图片
     * @param hid
     * @return
     */
    List<img> getAllImgsByHid(String hid);


    /**
     * 查询条件下的总数量
     * @param vo
     * @return
     */
    Integer getCountByCondition(QueryVo vo);

    /**
     * 查询条件下的所有房源
     * @param vo
     * @return
     */
    List<house> queryHousesByCondition(QueryVo vo);


    /**
     * 删除房源的图片集
     * @param hid
     */
    void delAllImgsByHid(String hid);

    /**
     * 删除房源信息
     * @param hid
     * @return
     */
    int delHouseByHid(String hid);

    /**
     * 增加房源图片
     * @param imgs
     */
    void addImgs(img img);

    /**
     * 更新房源信息
     * @param house
     * @return
     */
    int updateHouseByHid(house house);

    /**
     * 新增房源信息
     * @param house
     * @return
     */
    int addHouse(house house);

    /**
     * 修改房源状态
     * @param hid
     */
    void updateHouseStateByHid(String hid);

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
     * 查询房东房屋数量
     */
    int queryCountByLid(String lid);

    Integer getCountByDate(String hdate);

    Integer delHouseByLid(String lid);
}
