package com.lazycece.sbac.mysql.multi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lazycece
 */
@Configuration
public class MultiDataSource {

    public static final String MASTER_DATA_SOURCE = "masterDataSource";
    public static final String LOG_DATA_SOURCE = "logDataSource";

    @ConfigurationProperties(prefix = "datasource.master")
    private DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @ConfigurationProperties(prefix = "datasource.log")
    private DataSource logDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(MASTER_DATA_SOURCE, masterDataSource());
        dataSourceMap.put(LOG_DATA_SOURCE, logDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }
}
