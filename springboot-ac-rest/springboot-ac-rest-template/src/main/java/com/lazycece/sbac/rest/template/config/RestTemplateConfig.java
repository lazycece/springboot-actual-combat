package com.lazycece.sbac.rest.template.config;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.protocol.HttpContext;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import sun.net.www.http.HttpClient;

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
//                .customizers(new ProxyCustomizer())
                .build();
    }

//    class ProxyCustomizer implements RestTemplateCustomizer {
//
//        @Override
//        public void customize(RestTemplate restTemplate) {
//            HttpHost proxy = new HttpHost("proxy.example.com");
//            HttpClient httpClient = Httpclient.create()
//                    .setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
//
//                        @Override
//                        public HttpHost determineProxy(HttpHost target,
//                                                       HttpRequest request, HttpContext context)
//                                throws HttpException {
//                            if (target.getHostName().equals("192.168.0.5")) {
//                                return null;
//                            }
//                            return super.determineProxy(target, request, context);
//                        }
//
//                    }).build();
//            restTemplate.setRequestFactory(
//                    new HttpComponentsClientHttpRequestFactory(httpClient));
//        }
//
//    }

}
