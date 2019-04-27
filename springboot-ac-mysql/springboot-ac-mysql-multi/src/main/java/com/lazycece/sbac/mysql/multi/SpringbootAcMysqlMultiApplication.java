package com.lazycece.sbac.mysql.multi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = {"com.lazycece.sbac.mysql.data.dao"})
public class SpringbootAcMysqlMultiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAcMysqlMultiApplication.class, args);
    }

}
