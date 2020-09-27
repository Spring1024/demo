package com.spring1024.dao;

import java.util.List;
import com.spring1024.bean.BQueryVo;
import com.spring1024.bean.log;
import org.springframework.stereotype.Component;

@Component
public interface logDao {

	/**
	 * 插入日志
	 * @param log
	 */
	void insertLog(log log);

	/**
	 * 更新日志
	 * @param log
	 */
	void updateLog(log log);

	/**
	 * 获取日志的总数
	 * @param vo 
	 * @return
	 */
	Integer queryTotalLogs(BQueryVo vo);

	/**
	 * 查询日志
	 * @param vo
	 * @return
	 */
	List<log> querySysLog(BQueryVo vo);
}