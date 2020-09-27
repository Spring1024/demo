package com.spring1024.service.impl;

import java.util.List;

import com.spring1024.bean.log;
import com.spring1024.dao.logDao;
import com.spring1024.util.BPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.spring1024.bean.BQueryVo;
import com.spring1024.service.logService;

@Service
public class logServiceImpl implements logService {

	@Autowired
	private logDao logDao;
	
	@Override
	@Transactional
	public void insertLog(log log) {
		logDao.insertLog(log);
	}

	@Override
	@Transactional
	public void updateLog(log log) {
		logDao.updateLog(log);
	}

	@Override
	public BPageBean<log> querySysLog(BQueryVo vo) {
		
		//得到日志的总记录数
		Integer total = logDao.queryTotalLogs(vo);
		//按条件查询日志
		List<log> logs = logDao.querySysLog(vo);
		
		BPageBean<log> pb = new BPageBean<>();
		pb.setTotal(total);
		pb.setRows(logs);
		return pb;
	}

}
