package com.lazycece.sbac.mongodb.simple.repository;

import com.lazycece.sbac.mongodb.simple.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author lazycece
 * @date 2019/05/06
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void testInsert() {
        User user = new User();
        user.setUsername("simple");
        user.setPassword("123456");
        user.setTelephone("18888888888");
        user.setEditor("admin");
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userRepository.insert(user);
    }

    @Test
    public void testFindByUsername() {
        User user = userRepository.findByUsername("simple");
        System.out.println(user);
    }
}
