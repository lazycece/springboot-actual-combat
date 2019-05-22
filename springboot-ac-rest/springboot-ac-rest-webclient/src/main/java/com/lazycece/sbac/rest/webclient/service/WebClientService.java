package com.lazycece.sbac.rest.webclient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * @author lazycece
 * @date 2019/5/22
 */
@Service
public class WebClientService {

    private WebClient webClient;

    @Autowired
    public WebClientService(WebClient webClient) {
        this.webClient = webClient;
    }

    public void callRest() {
        Mono<String> response = webClient.get()
                .uri("/rest/{name}", "lazycece")
                .retrieve().bodyToMono(String.class);
        System.out.println(response.toString());
    }
}
