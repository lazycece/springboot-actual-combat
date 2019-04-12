package com.lazycece.sbac.mysql.multi.config;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author CC
 */
@Component
@Aspect
public class DataSourceConfig {

    @Before("@annotation(dataSource)")
    public void beforeSwitchDataSource(DataSource dataSource) {
        DynamicDataSource.changeDataSource(dataSource.value());
    }

    @After("@annotation(DataSource)")
    public void afterSwitchDataSource() {
        DynamicDataSource.clearDataSource();
    }
}