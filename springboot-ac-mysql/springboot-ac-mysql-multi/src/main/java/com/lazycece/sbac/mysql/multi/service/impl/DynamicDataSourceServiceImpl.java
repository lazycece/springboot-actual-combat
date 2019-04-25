package com.lazycece.sbac.mysql.multi.service.impl;

import com.lazycece.sbac.mysql.data.dao.log.SystemLogDao;
import com.lazycece.sbac.mysql.data.dao.master.UserDao;
import com.lazycece.sbac.mysql.data.domain.SystemLog;
import com.lazycece.sbac.mysql.data.domain.User;
import com.lazycece.sbac.mysql.multi.config.DataSource;
import com.lazycece.sbac.mysql.multi.config.MultiDataSource;
import com.lazycece.sbac.mysql.multi.service.DynamicDataSourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/4/18
 */
@Service
public class DynamicDataSourceServiceImpl implements DynamicDataSourceService {

    @Resource
    private UserDao userDao;
    @Resource
    private SystemLogDao systemLogDao;

    @Override
    @DataSource(value = MultiDataSource.MASTER_DATA_SOURCE)
    public void addUserInfo(User user) {
        userDao.insert(user);
    }

    @Override
    @DataSource(value = MultiDataSource.MASTER_DATA_SOURCE)
    public User getUserInfo(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    @DataSource(value = MultiDataSource.LOG_DATA_SOURCE)
    public void addSystemLog(SystemLog systemLog) {
        systemLogDao.insert(systemLog);
    }

    @Override
    @DataSource(value = MultiDataSource.LOG_DATA_SOURCE)
    public List<SystemLog> getSystemLogInfo(Date beginTime, Date endTime) {
        return systemLogDao.findByCreateTime(beginTime, endTime);
    }
}
