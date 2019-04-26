package com.lazycece.sbac.mysql.multi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.lazycece.sbac.mysql.*"})
public class SpringbootAcMysqlMulti2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAcMysqlMulti2Application.class, args);
	}

}
