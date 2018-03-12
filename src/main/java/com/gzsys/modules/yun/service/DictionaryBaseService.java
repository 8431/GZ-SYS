package com.gzsys.modules.yun.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.gzsys.common.util.CommonException;

import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2018/2/26 0026.
 * Email 1429264916@qq.com
 */
public interface DictionaryBaseService {
    /**
     * 分页查询任意数据
     * @param page
     * @param state
     * @return
     */
    Page<Map> queryPage(Page<Map> page, Map state);

    /**
     * 获取表得列和注释
     * @param tableName
     * @return
     */
    List<Map<String,Object>> getColumn(String tableName);

    /**
     * 批量新增
     * @return
     */
    int insert(Map<String,Object> param);
    /**
     * 批量修改
     * @return
     */
    int update(Map<String,Object> param);
    /**
     * 批量删除
     * @return
     */
    int delete(Map<String,Object> param);
}
