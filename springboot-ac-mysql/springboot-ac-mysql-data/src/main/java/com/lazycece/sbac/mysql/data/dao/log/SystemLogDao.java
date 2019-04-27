package com.lazycece.sbac.mysql.data.dao.log;

import com.lazycece.sbac.mysql.data.domain.SystemLog;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/04/25
 */
@Mapper
public interface SystemLogDao {

    void insert(SystemLog systemLog);

    List<SystemLog> findByCreateTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);
}
