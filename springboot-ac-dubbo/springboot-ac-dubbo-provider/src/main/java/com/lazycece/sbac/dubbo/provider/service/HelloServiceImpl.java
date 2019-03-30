package com.lazycece.sbac.dubbo.provider.service;

import com.lazycece.sbac.dubbo.api.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author lazycece
 * @date 2019/03/30
 */
@Component
@Service(version = "1.0.0", timeout = 3000)
public class HelloServiceImpl implements HelloService {

    @Value("${dubbo.application.name}")
    private String serviceName;

    @Override
    public String hello(String name) {
        return String.format("Hello, %s ! the service is %s", name, serviceName);
    }
}
