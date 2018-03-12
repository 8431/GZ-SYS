/**
 * projectName: fendo-plus-boot
 * fileName: DynamicDataSource.java
 * packageName: com.gzsys.common.datasources
 * date: 2018-02-01 2:12
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.common.datasources;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DynamicDataSource
 * @packageName: com.gzsys.common.datasources
 * @description: 动态数据源
 * @data: 2018-02-01 2:12
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public DynamicDataSource(DataSource defaultTargetDataSource, Map<String, DataSource> targetDataSources) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(new HashMap<>(targetDataSources));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }


}
