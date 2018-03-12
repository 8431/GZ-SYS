/**
 * projectName: fendo-plus-boot
 * fileName: DataSourceAspect.java
 * packageName: com.gzsys.common.datasources.aspect
 * date: 2018-02-01 2:18
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.datasources.aspect;

import com.gzsys.common.datasources.annotation.DataSource;
import com.gzsys.common.datasources.DataSourceNames;
import com.gzsys.common.datasources.DynamicDataSource;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DataSourceAspect
 * @packageName: com.gzsys.common.datasources.aspect
 * @description: 多数据源，切面处理类
 * @data: 2018-02-01 2:18
 **/
@Aspect
@Component
public class DataSourceAspect implements Ordered {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("@annotation(com.gzsys.common.datasources.annotation.DataSource)")
    public void dataSourcePointCut() {

    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
            DynamicDataSource.setDataSource(DataSourceNames.MASTER);
            logger.debug("set datasource is " + DataSourceNames.SLAVE);
        }else {
            DynamicDataSource.setDataSource(ds.name());
            logger.debug("set datasource is " + ds.name());
        }

        try {
            return point.proceed();
        } finally {
            DynamicDataSource.clearDataSource();
            logger.debug("clean datasource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
