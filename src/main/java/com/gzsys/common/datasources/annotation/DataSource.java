package com.gzsys.common.datasources.annotation;

import java.lang.annotation.*;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DataSource
 * @packageName: com.gzsys.common.datasources.annotation
 * @description: 多数据源注解
 * @data: 2018-02-01 2:15
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {
    String name() default "";
}
