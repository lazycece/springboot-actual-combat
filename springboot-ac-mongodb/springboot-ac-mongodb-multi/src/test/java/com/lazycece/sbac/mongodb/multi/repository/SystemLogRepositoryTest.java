package com.lazycece.sbac.mongodb.multi.repository;

import com.lazycece.sbac.mongodb.multi.entity.SystemLog;
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
 * @date 2019/05/06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SystemLogRepositoryTest {

    @Resource
    private SystemLogRepository systemLogRepository;

    @Test
    public void testInsert() {
        SystemLog systemLog = new SystemLog();
        systemLog.setEditor("lazycece");
        systemLog.setOperation("create a user: multi");
        systemLog.setCreateTime(new Date());
        systemLogRepository.insert(systemLog);
    }

    @Test
    public void testFindByUsername() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date beginTime = format.parse("2019-05-10");
        Date endTime = format.parse("2019-06-12");
        List<SystemLog> systemLogList =
                systemLogRepository.listLog(beginTime, endTime);
        System.out.println(systemLogList.toString());
    }
}
