package com.gzsys.modules.yun.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gzsys.modules.yun.entity.DiagnosisRecords;
import org.apache.ibatis.annotations.Param;

public interface DiagnosisRecordsMapper extends BaseMapper<DiagnosisRecords> {

    int insertSelective(DiagnosisRecords record);

    /**
     * 根据病历ID删除诊断_物理删除
     * @return
     */
    int deleteOK(@Param("sid") String sid);

}
