package com.lazycece.sbac.rest.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author lazycece
 * @date 2019/5/22
 */
@Service
public class RestTemplateService {

    private RestTemplate restTemplate;

    @Autowired
    public RestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void callRest() {
        String response = restTemplate.getForObject("/rest/{name}", String.class, "lazycece");
        System.out.println(response);
    }
}
