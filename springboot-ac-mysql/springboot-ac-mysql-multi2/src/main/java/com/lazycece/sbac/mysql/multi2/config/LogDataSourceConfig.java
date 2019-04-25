package com.lazycece.sbac.mysql.multi2.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author lazycece
 * @date 2019/4/25
 */
@Configuration
@MapperScan(basePackages = {"com.lazycece.sbac.mysql.dao.log"},
        sqlSessionFactoryRef = "logSqlSessionFactory",
        sqlSessionTemplateRef = "logSqlSessionTemplate")
public class LogDataSourceConfig {

    @Bean(name = "logDataSource")
    @ConfigurationProperties(prefix = "datasource.log")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "logSqlSessionFactory")
    public SqlSessionFactory sentinelSqlSessionFactory(@Qualifier("logDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "logTransactionManager")
    public DataSourceTransactionManager sentinelTransactionManager(@Qualifier("logDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "logSqlSessionTemplate")
    public SqlSessionTemplate sentinelSqlSessionTemplate(@Qualifier("logSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
