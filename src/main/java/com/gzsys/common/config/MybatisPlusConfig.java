/**
 * projectName: fendo-plus-boot
 * fileName: MybatisPlusConfig.java
 * packageName: com.fendo.mybatis.plus.config
 * date: 2018-01-12 23:13
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MybatisPlusConfig
 * @packageName: com.fendo.mybatis.plus.config
 * @description: Mybatis-plus配置类
 * @data: 2018-01-12 23:13
 **/
@Configuration
@MapperScan(basePackages = {"com.gzsys.modules.yun.mapper"})
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDialectType("oracle");
        return paginationInterceptor;
    }
}
