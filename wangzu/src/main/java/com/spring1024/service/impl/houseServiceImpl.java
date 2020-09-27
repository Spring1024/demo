package com.spring1024.service.impl;

import java.util.List;

import com.spring1024.bean.house;
import com.spring1024.dao.houseDao;
import com.spring1024.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring1024.util.PageEnum;
import com.spring1024.util.UuidBean;
import com.spring1024.bean.QueryVo;
import com.spring1024.bean.img;
import com.spring1024.service.houseService;

@Service
public class houseServiceImpl implements houseService {

    @Autowired
    private houseDao houseDao;

    @Override
    public List<house> queryHouses() {
        return houseDao.queryHouses();
    }

    @Override
    public List<house> queryAllHouses(Integer page, Integer limit) {
        return houseDao.queryAllHouses(page,limit);
    }


    @Override
    public house queryHouseByHid(String hid) {
        return houseDao.queryHouseByHid(hid);
    }

    @Override
    public List<img> getAllImgsByHid(String hid) {
        return houseDao.getAllImgsByHid(hid);
    }

    @Override
    public PageBean<house> queryHousesByCondition(QueryVo vo, int pc) {
        Integer ps = PageEnum.HOUSES_PAGE_SIZE;
        //设置limit x, y
        vo.setX((pc - 1) * ps);
        vo.setY(ps);

        //得到条件下的总记录数
        Integer tr = houseDao.getCountByCondition(vo);
        if (tr == null) {
            tr = 1;
        }

        //查询条件下的所有房源
        List<house> hs = houseDao.queryHousesByCondition(vo);

        PageBean<house> pb = new PageBean<>();

        pb.setBeanList(hs);
        pb.setPs(ps);
        pb.setTr(tr);

        return pb;
    }

    @Override
    public void delAllImgsByHid(String hid) {
        houseDao.delAllImgsByHid(hid);
    }

    @Override
    public void delHouseByHid(String hid) {
        int count = houseDao.delHouseByHid(hid);
        if (count != 1) {
            throw new RuntimeException("删除房源信息[" + hid + "]失败!");
        }
    }

    @Override
    public void addImgs(img img) {
        houseDao.addImgs(img);
    }

    @Override
    public void updateHouseByHid(house house) {
        houseDao.updateHouseByHid(house);
    }

    @Override
    public void addHouse(house house) {
        int count = houseDao.addHouse(house);
        if (count != 1) {
            throw new RuntimeException("新增房源信息失败!");
        }
    }

    @Override
    public List<house> queryLikeHouses(house house) {

        return houseDao.queryLikeHouses(house);
    }

    @Override
    public int queryClick() {
        return houseDao.queryClick();
    }

    @Override
    public int queryClickByLid(String lid) {
        // TODO Auto-generated method stub
        return houseDao.queryClickByLid(lid);
    }

    @Override
    public int queryCount() {
        // TODO Auto-generated method stub
        return houseDao.queryCount();
    }

    @Override
    public int queryCountByLid(String lid) {
        // TODO Auto-generated method stub
        return houseDao.queryCountByLid(lid);
    }

    @Override
    public Integer getCountByDate(String hdate) {
        return houseDao.getCountByDate(hdate);
    }

    @Override
    public Integer delHouseByLid(String lid) {
        return houseDao.delHouseByLid(lid);
    }


}
