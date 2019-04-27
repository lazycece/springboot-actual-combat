package com.lazycece.sbac.mysql.multi.service;

import com.lazycece.sbac.mysql.data.domain.Status;
import com.lazycece.sbac.mysql.data.domain.SystemLog;
import com.lazycece.sbac.mysql.data.domain.User;
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
public class DynamicDataSourceServiceTest {

    @Resource
    private DynamicDataSourceService dynamicDataSourceService;

    @Test
    public void testAddUserInfo() {
        User user = new User();
        user.setUsername("lazycece");
        user.setPassword("123456");
        user.setTelephone("18888888888");
        user.setEditor("admin");
        user.setStatus(Status.active);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        dynamicDataSourceService.addUserInfo(user);
    }

    @Test
    public void testGetUserInfo() {
        User user = dynamicDataSourceService.getUserInfo("lazycece");
        System.out.println(user);
    }

    @Test
    public void testAddSystemLog() {
        SystemLog systemLog = new SystemLog();
        systemLog.setEditor("lazycece");
        systemLog.setOperation("create a user: lazycece");
        systemLog.setCreateTime(new Date());
        dynamicDataSourceService.addSystemLog(systemLog);
    }

    @Test
    public void testGetSystemLogInfo() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = format.parse("2019-04-25");
        Date endTime = format.parse("2019-04-28");
        List<SystemLog> systemLogList =
                dynamicDataSourceService.getSystemLogInfo(beginTime, endTime);
        System.out.println(systemLogList.toString());
    }

}
