package com.lazycece.sbac.mysql.multi2.service;

import com.lazycece.sbac.mysql.data.domain.SystemLog;

import java.util.Date;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/04/25
 */
public interface SystemLogService {

    void addSystemLog(SystemLog systemLog);

    List<SystemLog> getSystemLogInfo(Date beginTime, Date endTime);
}
