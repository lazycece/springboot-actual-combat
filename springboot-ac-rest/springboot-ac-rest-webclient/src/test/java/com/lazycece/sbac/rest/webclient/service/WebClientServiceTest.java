package com.lazycece.sbac.rest.webclient.service;

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
public class WebClientServiceTest {

    @Resource
    private WebClientService webClientService;

    @Test
    public void testCallRest() {
        webClientService.callRest();
    }
}
