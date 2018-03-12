package com.gzsys.modules.yun.mapper;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gzsys.common.util.CommonException;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * Created by dlf on 2018/2/26 0026.
 * Email 1429264916@qq.com
 */
public interface DictionaryBaseMapper {
    /**
     * 获取列名和注释
     * @param tableName
     * @return
     * @throws CommonException
     */
    @Select("select  t.COLUMN_NAME, u.comments, t.DATA_TYPE, t.DATA_LENGTH from user_tab_cols t, user_col_comments u  where t.TABLE_NAME = u.table_name   and t.COLUMN_NAME = u.column_name and u.table_name =#{0}")
    List<Map<String,Object>> getColumn(String tableName);

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page
     *            翻页对象，可以作为 xml 参数直接使用，传递参数 Page 即自动分页
     *            状态
     * @return
     */
    @Select("${sql}")
    List<Map> queryPage(Pagination page,Map param);

    /**
     * 批量新增
     * @param mp
     * @return
     */
    int insert(Map<String,Object> mp);
}
