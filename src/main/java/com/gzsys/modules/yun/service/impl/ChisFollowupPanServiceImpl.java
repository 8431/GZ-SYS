/**
 * projectName: GZ
 * fileName: ChisFollowupPanServiceImpl.java
 * packageName: com.gzsys.modules.yun.service.impl
 * date: 2018-02-01 15:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.modules.yun.entity.ChisFollowupPan;
import com.gzsys.modules.yun.entity.DiagnosisRecords;
import com.gzsys.modules.yun.mapper.ChisFollowupPanMapper;
import com.gzsys.modules.yun.mapper.DiagnosisRecordsMapper;
import com.gzsys.modules.yun.service.ChisFollowupPanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: ChisFollowupPanServiceImpl
 * @packageName: com.gzsys.modules.yun.service.impl
 * @description:
 * @data: 2018-02-01 15:22
 **/
@Service
public class ChisFollowupPanServiceImpl extends ServiceImpl<ChisFollowupPanMapper, ChisFollowupPan> implements ChisFollowupPanService {

    @Autowired
    private ChisFollowupPanMapper chisFollowupPanMapper;

    @Override
    public int addFollowupPlaList(List<ChisFollowupPan> chisFollowupPan) {
        for (ChisFollowupPan dTfollowupPlan : chisFollowupPan) {
            chisFollowupPanMapper.insertSelective(dTfollowupPlan);
        }
        return 0;
    }

    @Override
    public int updateFollowupPlan(ChisFollowupPan dTfollowupPlan) {
        return chisFollowupPanMapper.updateByPrimaryKeySelective(dTfollowupPlan);
    }

    @Override
    public int insertFollowupPlan(ChisFollowupPan dTfollowupPlan) {
        return chisFollowupPanMapper.insertSelective(dTfollowupPlan);
    }

    @Override
    public List<ChisFollowupPan> getFollowupPlanList(String sicguid) {
        return chisFollowupPanMapper.selectDTfollowupPlanList(sicguid);
    }

    @Override
    public int deleteByFollowupPlan(String sickguid) {
        return chisFollowupPanMapper.deleteByFollowupPlan(sickguid);
    }
}
