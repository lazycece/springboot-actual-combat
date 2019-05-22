package com.lazycece.sbac.rest.webclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.Resource;

/**
 * @author lazycece
 * @date 2019/5/22
 */
@Configuration
public class WebClientConfig {

    @Resource
    private WebClient.Builder webClientBuilder;

    @Bean
    public WebClient buildWebClient() {
        return webClientBuilder.baseUrl("http://127.0.0.1:8080").build();
    }
}
