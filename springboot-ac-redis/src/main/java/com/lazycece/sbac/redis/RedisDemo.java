package com.lazycece.sbac.redis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/6/14
 */
@Component
public class RedisDemo implements CommandLineRunner {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... args) throws Exception {
        redisTemplate.opsForValue().set("key", "hello");
        String value = (String) redisTemplate.opsForValue().get("key");
        System.out.println(value);

        stringRedisTemplate.opsForValue().set("string-key", "hello");
        value = stringRedisTemplate.opsForValue().get("string-key");
        System.out.println(value);
    }
}
