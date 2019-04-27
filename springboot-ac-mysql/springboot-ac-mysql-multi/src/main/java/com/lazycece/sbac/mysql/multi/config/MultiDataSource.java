package com.lazycece.sbac.mysql.multi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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

    @Bean(name = MultiDataSource.MASTER_DATA_SOURCE)
    @ConfigurationProperties(prefix = "datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = MultiDataSource.LOG_DATA_SOURCE)
    @ConfigurationProperties(prefix = "datasource.log")
    public DataSource logDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dataSource() {
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setDefaultTargetDataSource(masterDataSource());
        Map<Object, Object> dataSourceMap = new HashMap<>(4);
        dataSourceMap.put(MASTER_DATA_SOURCE, masterDataSource());
        dataSourceMap.put(LOG_DATA_SOURCE, logDataSource());
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        return dynamicDataSource;
    }
}
