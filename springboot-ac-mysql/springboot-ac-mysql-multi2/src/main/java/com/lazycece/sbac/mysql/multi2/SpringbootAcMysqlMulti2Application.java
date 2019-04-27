package com.lazycece.sbac.mysql.multi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(
        exclude = {DataSourceAutoConfiguration.class})
public class SpringbootAcMysqlMulti2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAcMysqlMulti2Application.class, args);
    }

}
