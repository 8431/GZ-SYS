/**
 * projectName: GZ
 * fileName: InspectionItemsServiceImpl.java
 * packageName: com.gzsys.modules.yun.service.impl
 * date: 2018-02-01 15:20
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.modules.yun.entity.ChisFollowupPan;
import com.gzsys.modules.yun.entity.InspectionItems;
import com.gzsys.modules.yun.entity.Sickbldtl;
import com.gzsys.modules.yun.mapper.InspectionItemsMapper;
import com.gzsys.modules.yun.mapper.SickbldtlMapper;
import com.gzsys.modules.yun.service.InspectionItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: InspectionItemsServiceImpl
 * @packageName: com.gzsys.modules.yun.service.impl
 * @description:
 * @data: 2018-02-01 15:20
 **/
@Service
public class InspectionItemsServiceImpl extends ServiceImpl<InspectionItemsMapper, InspectionItems> implements InspectionItemsService {

    @Autowired
    public InspectionItemsMapper inspectionItemsMapper;


    @Override
    public int insertSelective(InspectionItems inspectionItems) {
        return inspectionItemsMapper.insertSelective(inspectionItems);
    }

    @Override
    public int addInspectionItemsList(List<InspectionItems> inspectionItemsList) {

        return 0;
    }

    @Override
    public List<InspectionItems> getInspectionItemsList(String sickguid) {
        return null;
    }

    @Override
    public int deleteByInspectionItems(String sickguid) {
        return inspectionItemsMapper.deleteByInspectionItems(sickguid);
    }
}
