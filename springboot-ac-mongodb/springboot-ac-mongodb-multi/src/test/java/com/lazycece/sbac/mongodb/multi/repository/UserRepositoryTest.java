package com.lazycece.sbac.mongodb.multi.repository;

import com.lazycece.sbac.mongodb.multi.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lazycece
 * @date 2019/05/06
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("multi");
        user.setPassword("123456");
        user.setTelephone("18888888888");
        user.setEditor("lazycece");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userRepository.insert(user);
    }

    @Test
    public void testFindByUsername() {
        User user = userRepository.findByUsername("multi");
        System.out.println(user);
    }
}
