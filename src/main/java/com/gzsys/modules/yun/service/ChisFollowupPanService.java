package com.gzsys.modules.yun.service;

import com.baomidou.mybatisplus.service.IService;
import com.gzsys.modules.yun.entity.ChisChartMsg;
import com.gzsys.modules.yun.entity.ChisFollowupPan;

import java.util.List;


public interface ChisFollowupPanService extends IService<ChisFollowupPan> {

    /**
     * 新增随访计划
     * @param DTfollowupPlan
     * @return SimpleResult
     */
    int addFollowupPlaList(List<ChisFollowupPan> DTfollowupPlan);


    /**
     * 随访计划更新
     * @param dTfollowupPlan
     * @return
     */
    int updateFollowupPlan(ChisFollowupPan dTfollowupPlan);

    /**
     * 新增随访计划
     * @param dTfollowupPlan
     * @return
     */
    int insertFollowupPlan(ChisFollowupPan dTfollowupPlan);

    /**
     * 根据病历ID获取随访计划
     * @param sicguid
     * @return
     */
    List<ChisFollowupPan> getFollowupPlanList(String sicguid);

    /**
     * 根据病历ID删除随访计划
     * @param sickguid
     * @return
     */
    int deleteByFollowupPlan(String sickguid);


}
