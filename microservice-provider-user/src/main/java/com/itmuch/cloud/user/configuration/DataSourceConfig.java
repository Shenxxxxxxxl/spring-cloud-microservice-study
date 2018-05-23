package com.itmuch.cloud.user.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    /****
     *
     * @Title: itmuchDataSource
     * @Description: 数据源配置
     * @param   输入参数
     * @return DataSource    返回类型 
     * @throws
     */
    @Bean(name = "itmuchDataSource")
    @Qualifier("itmuchDataSource")
    @ConfigurationProperties(prefix="spring.datasource.itmuch")
    public DataSource itmuchDataSource() {
        return DataSourceBuilder.create().build();
    }
    /****
     *
     * @Title: itmuchJdbcTemplate
     * @Description: 数据连接tempp
     * @param   输入参数
     * @return JdbcTemplate    返回类型 
     * @throws
     */
    @Bean(name = "itmuchJdbcTemplate")
    public JdbcTemplate itmuchJdbcTemplate(
            @Qualifier("itmuchDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
