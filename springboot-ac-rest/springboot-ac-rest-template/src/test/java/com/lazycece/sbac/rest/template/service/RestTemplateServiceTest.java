package com.lazycece.sbac.rest.template.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/5/22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateServiceTest {

    @Resource
    private RestTemplateService restTemplateService;

    @Test
    public void testCallRest() {
        restTemplateService.callRest();
    }
}
