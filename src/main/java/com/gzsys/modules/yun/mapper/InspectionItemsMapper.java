package com.gzsys.modules.yun.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gzsys.modules.yun.entity.InspectionItems;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InspectionItemsMapper extends BaseMapper<InspectionItems> {

    InspectionItems selectByPrimaryKey(String guid);

    List<InspectionItems> selectAll(InspectionItems record);

    int updateByPrimaryKeySelective(InspectionItems record);

    int insertSelective(InspectionItems record);

    /**
     * 根据病历ID删除检查项
     * @param sickguid
     * @return
     */
    int deleteByInspectionItems(@Param("sickguid") String sickguid);
}
