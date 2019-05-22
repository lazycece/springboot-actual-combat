package com.lazycece.sbac.rest.template.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author lazycece
 * @date 2019/5/22
 */
@Configuration
public class RestTemplateConfig {

    @Resource
    private RestTemplateBuilder restTemplateBuilder;

    @Bean
    public RestTemplate buildRestTemplate() {
        return restTemplateBuilder
                .rootUri("http://127.0.0.1:8080")
                .setConnectTimeout(Duration.ofSeconds(5))
                .build();
    }
}
