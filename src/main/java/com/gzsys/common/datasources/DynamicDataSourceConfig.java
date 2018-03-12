/**
 * projectName: fendo-plus-boot
 * fileName: DynamicDataSourceConfig.java
 * packageName: com.gzsys.common.datasources
 * date: 2018-02-01 2:13
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.datasources;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DynamicDataSourceConfig
 * @packageName: com.gzsys.common.datasources
 * @description: 配置多数据源
 * @data: 2018-02-01 2:13
 **/
@Configuration
public class DynamicDataSourceConfig {

    @Bean
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<String, DataSource>();
        targetDataSources.put(DataSourceNames.MASTER, firstDataSource);
        targetDataSources.put(DataSourceNames.SLAVE, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }

}
