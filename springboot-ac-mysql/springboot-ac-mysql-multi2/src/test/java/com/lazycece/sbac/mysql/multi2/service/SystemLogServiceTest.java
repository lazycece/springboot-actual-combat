package com.lazycece.sbac.mysql.multi2.service;

import com.lazycece.sbac.mysql.data.domain.SystemLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author lazycece
 * @date 2019/4/25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemLogServiceTest {

    @Resource
    private SystemLogService systemLogService;

    @Test
    public void testAddSystemLog() {
        SystemLog systemLog = new SystemLog();
        systemLog.setEditor("lazycece");
        systemLog.setOperation("create a user: multi2");
        systemLog.setCreateTime(new Date());
        systemLogService.addSystemLog(systemLog);
    }

    @Test
    public void testGetSystemLogInfo() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = format.parse("2019-04-25");
        Date endTime = format.parse("2019-04-28");
        List<SystemLog> systemLogList =
                systemLogService.getSystemLogInfo(beginTime, endTime);
        System.out.println(systemLogList.toString());
    }

}
