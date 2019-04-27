package com.lazycece.sbac.mysql.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lazycece.sbac.mysql.data.dao"})
public class SpringbootAcMysqlSimpleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAcMysqlSimpleApplication.class, args);
    }

}
