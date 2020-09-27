package com.spring1024.service;

import com.spring1024.bean.BQueryVo;
import com.spring1024.bean.log;
import com.spring1024.util.BPageBean;

/**
 * 日志管理service层接口
 *
 * @author hss
 */
public interface logService {

    /**
     * 插入日志
     *
     * @param log
     */
    void insertLog(log log);

    /**
     * 跟新日志
     *
     * @param log
     */
    void updateLog(log log);

    /**
     * 查询日志
     *
     * @param vo
     * @return
     */
    BPageBean<log> querySysLog(BQueryVo vo);

}