package com.lazycece.sbac.mysql.simple.service;

import com.lazycece.sbac.mysql.data.domain.Status;
import com.lazycece.sbac.mysql.data.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lazycece
 * @date 2019/4/25
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Resource
    private UserService userService;

    @Test
    public void testAddUserInfo() {
        User user = new User();
        user.setUsername("simple");
        user.setPassword("123456");
        user.setTelephone("18888888888");
        user.setEditor("admin");
        user.setStatus(Status.active);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.addUserInfo(user);
    }

    @Test
    public void testGetUserInfo() {
        User user = userService.getUserInfo("simple");
        System.out.println(user);
    }
}
