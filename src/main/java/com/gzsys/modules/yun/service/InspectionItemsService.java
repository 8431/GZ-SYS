package com.gzsys.modules.yun.service;

import com.baomidou.mybatisplus.service.IService;
import com.gzsys.modules.yun.entity.InspectionItems;
import com.gzsys.modules.yun.entity.Inspectionitem;

import java.util.List;

public interface InspectionItemsService extends IService<InspectionItems> {

    int insertSelective(InspectionItems inspectionItems);

    /**
     * 新增检查项目
     * @param inspectionItemsList
     * @return int
     */
    int addInspectionItemsList(List<InspectionItems> inspectionItemsList);

    /**
     * 根据病历ID获取检查项目
     * @param sickguid
     * @return
     */
    List<InspectionItems> getInspectionItemsList(String sickguid);

    /**
     * 根据病历ID,删除检查项
     * @param sickguid
     * @return
     */
    int deleteByInspectionItems(String sickguid);


}
