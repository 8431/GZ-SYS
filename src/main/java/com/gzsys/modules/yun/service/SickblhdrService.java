package com.gzsys.modules.yun.service;


import com.baomidou.mybatisplus.service.IService;
import com.gzsys.modules.yun.entity.Sickbldtl;
import com.gzsys.modules.yun.entity.Sickblhdr;
import com.gzsys.modules.yun.request.SickbldtlRequest;

import java.util.List;

public interface SickblhdrService extends IService<Sickblhdr> {

    /**
     * 根据主键删除病历_物理删除
     * @param id
     * @return
     */
    int deleteOK(String id);

    int insertSelective(Sickblhdr sickblhdr);

    /**
     * 新增用药方案
     * @param sickbldtlRequest
     * @return SimpleResult
     */
    int addRegimenList(List<SickbldtlRequest> sickbldtlRequest);

    /**
     * 新增用药方案
     * @param dtsickbldtl
     * @return
     */
    int insertDTsickbldtl(Sickbldtl dtsickbldtl);

    /**
     * 更新用药方案
     * @param dtsickbldtl
     * @return
     */
    int updateDTsickbldtl(Sickblhdr dtsickbldtl);

    /**
     * 根据病历ID删除用药方案
     * @param sickguid
     * @return
     */
    int deleteDTsickbldtl(String sickguid);



}
