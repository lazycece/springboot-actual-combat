package com.lazycece.sbac.mysql.multi.service;

import com.lazycece.sbac.mysql.data.domain.SystemLog;
import com.lazycece.sbac.mysql.data.domain.User;

import java.util.Date;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/4/18
 */
public interface DynamicDataSourceService {

    void addUserInfo(User user);

    User getUserInfo(String username);

    void addSystemLog(SystemLog systemLog);

    List<SystemLog> getSystemLogInfo(Date beginTime, Date endTime);
}
