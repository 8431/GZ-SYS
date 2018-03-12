package com.gzsys.modules.yun.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gzsys.modules.yun.entity.ChisFollowupPan;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ChisFollowupPanMapper extends BaseMapper<ChisFollowupPan> {

    int insertSelective(ChisFollowupPan record);

    int updateByPrimaryKeySelective(ChisFollowupPan record);

    /**
     * 根据病历ID获取随访信息
     * @param sickguid
     * @return
     * @throws Exception
     */
    List<ChisFollowupPan> selectDTfollowupPlanList(String sickguid);

    /**
     * 根据病历ID删除随访计划
     * @param sickguid
     * @return
     */
    int deleteByFollowupPlan(@Param("sickguid") String sickguid);
}
