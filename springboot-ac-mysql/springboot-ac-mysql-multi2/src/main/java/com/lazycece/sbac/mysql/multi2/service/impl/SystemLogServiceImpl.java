package com.lazycece.sbac.mysql.multi2.service.impl;

import com.lazycece.sbac.mysql.data.dao.log.SystemLogDao;
import com.lazycece.sbac.mysql.data.domain.SystemLog;
import com.lazycece.sbac.mysql.multi2.service.SystemLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/04/25
 */
@Service
public class SystemLogServiceImpl implements SystemLogService {

    @Resource
    private SystemLogDao systemLogDao;

    @Override
    public void addSystemLog(SystemLog systemLog) {
        systemLogDao.insert(systemLog);
    }

    @Override
    public List<SystemLog> getSystemLogInfo(Date beginTime, Date endTime) {
        return systemLogDao.findByCreateTime(beginTime,endTime);
    }
}
