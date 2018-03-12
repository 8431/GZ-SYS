package com.gzsys.modules.yun.service;

import com.baomidou.mybatisplus.service.IService;
import com.gzsys.modules.yun.entity.ChisFollowupPan;
import com.gzsys.modules.yun.entity.DiagnosisRecords;

import java.util.List;

public interface DiagnosisRecordsService extends IService<DiagnosisRecords> {

    /**
     * 批量新增诊断
     * @param diagnosisRecordsList
     * @return
     */
    int inserList(List<DiagnosisRecords> diagnosisRecordsList);

    /**
     * 根据病历ID删除诊断
     * @return
     */
    int deleteOK(String sid);

}
