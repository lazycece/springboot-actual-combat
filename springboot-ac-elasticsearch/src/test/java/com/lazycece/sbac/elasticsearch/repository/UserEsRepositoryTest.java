package com.lazycece.sbac.elasticsearch.repository;

import com.lazycece.sbac.elasticsearch.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEsRepositoryTest implements Consumer<User> {

    @Resource
    private UserEsRepository userEsRepository;

    @Test
    public void testSave() {
        User user = User.builder()
                .username("lazycece")
                .name("W")
                .age(99)
                .createTime(new Date())
                .updateTime(new Date())
                .build();
        userEsRepository.save(user);
        System.out.println("finish insert a user");
    }

    @Test
    public void testFindAll() {
        Iterable<User> books = userEsRepository.findAll();
        books.forEach(this);
    }

    @Override
    public void accept(User user) {
        System.out.println(user.toString());
    }

    @Override
    public Consumer<User> andThen(Consumer<? super User> after) {
        return null;
    }
}
