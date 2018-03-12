/**
 * projectName: GZ
 * fileName: DiagnosisRecordsServiceImpl.java
 * packageName: com.gzsys.modules.yun.service.impl
 * date: 2018-02-01 15:22
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.modules.yun.entity.DiagnosisRecords;
import com.gzsys.modules.yun.entity.HealtLogHistory;
import com.gzsys.modules.yun.mapper.DiagnosisRecordsMapper;
import com.gzsys.modules.yun.mapper.HealtLogHistoryMapper;
import com.gzsys.modules.yun.service.DiagnosisRecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: DiagnosisRecordsServiceImpl
 * @packageName: com.gzsys.modules.yun.service.impl
 * @description:
 * @data: 2018-02-01 15:22
 **/
@Service
public class DiagnosisRecordsServiceImpl extends ServiceImpl<DiagnosisRecordsMapper, DiagnosisRecords> implements DiagnosisRecordsService {

    @Autowired
    private DiagnosisRecordsMapper diagnosisRecordsMapper;

    @Override
    public int inserList(List<DiagnosisRecords> diagnosisRecordsList) {
        if(diagnosisRecordsList.size()>0){
            for (int i = 0; i < diagnosisRecordsList.size(); i++) {
                diagnosisRecordsMapper.insertSelective(diagnosisRecordsList.get(i));
            }
        }
        return 0;
    }

    @Override
    public int deleteOK(String sid) {
        return diagnosisRecordsMapper.deleteOK(sid);
    }
}
