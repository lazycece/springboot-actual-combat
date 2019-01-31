package com.lazycece.sbac.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author lazycece
 * @date 2019/1/30
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Bean
    public Docket buildApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.lazycece.sbac.swagger2.controller"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("SpringBoot Swagger2 Restful Api")
                .description("SpringBoot 使用 Swagger2 生成 Restful Api .  ")
                .version("1.0")
                .contact(new Contact(
                        "lazycece",
                        "https://lazycece.github.io",
                        "lazycece@qq.com"))
                .build();
    }
}
