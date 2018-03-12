package com.gzsys.modules.yun.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.PageHelper;
import com.google.gson.Gson;
import com.gzsys.common.util.CommonException;
import com.gzsys.common.util.PropertyUtil;
import com.gzsys.modules.yun.mapper.DictionaryBaseMapper;
import com.gzsys.modules.yun.service.DictionaryBaseService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Created by dlf on 2018/2/26 0026.
 * Email 1429264916@qq.com
 */
@Service
public class DictionaryBaseServiceImpl implements DictionaryBaseService {
    public static final Map<String, Object> TABLENAME;

    static {
        String tableName = PropertyUtil.getPropery("tableName");
        Gson gn = new Gson();
        TABLENAME = gn.fromJson(tableName, Map.class);
    }

    @Autowired
    DictionaryBaseMapper dictionarybasemapper;

    @Override
    public Page<Map> queryPage(Page<Map> page, Map param) {
        //通过表名分页查询，自定义sql查询，默认执行该表的全表查询
        // page.setSearchCount(false);
        String tableName = (String) param.get("table");
        String sql = PropertyUtil.getPropery("QUERY_" + tableName);
        if (StringUtils.isEmpty(sql)) {
            sql = "select * from " + tableName;
        }
        param.put("table", tableName);
        param.put("sql", sql);
        return page.setRecords(dictionarybasemapper.queryPage(page, param));
    }

    @Override
    public List<Map<String, Object>> getColumn(String table) {
        return dictionarybasemapper.getColumn(table);
    }

    @Override
    public int insert(Map<String, Object> insertParam) {
        Map<String, Object> param = new HashMap<>();
        List<Map<String, Object>> paramData = (List<Map<String, Object>>) insertParam.get("data");
        List<String> InsertMapkey = new ArrayList<>();
        Map<String, Object> mpKey = paramData.get(0);
        Set<String> key = mpKey.keySet();
        Iterator it = key.iterator();
        while (it.hasNext()) {
            InsertMapkey.add((String) it.next());
        }
        param.put("InsertMap", InsertMapkey);
        param.put("InsertMapVal", paramData);
        param.put("table", insertParam.get("table"));
        return dictionarybasemapper.insert(param);
    }

    @Override
    public int update(Map<String, Object> param) {
        return 0;
    }

    @Override
    public int delete(Map<String, Object> param) {
        return 0;
    }


    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("1,2,3,");
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, "");
        System.out.println(sb.toString());

    }
}
