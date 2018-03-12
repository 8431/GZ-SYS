/**
 * projectName: GZ
 * fileName: SickblhdrServiceImpl.java
 * packageName: com.gzsys.modules.yun.service.impl
 * date: 2018-02-01 15:19
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.modules.yun.entity.Sickbldtl;
import com.gzsys.modules.yun.entity.Sickblhdr;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.mapper.SickbldtlMapper;
import com.gzsys.modules.yun.mapper.SickblhdrMapper;
import com.gzsys.modules.yun.mapper.UserBaseMapper;
import com.gzsys.modules.yun.request.SickbldtlRequest;
import com.gzsys.modules.yun.service.SickbldtlService;
import com.gzsys.modules.yun.service.SickblhdrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version: V1.0
 * @author: fendo
 * @className: SickblhdrServiceImpl
 * @packageName: com.gzsys.modules.yun.service.impl
 * @description:
 * @data: 2018-02-01 15:19
 **/
@Service
public class SickblhdrServiceImpl extends ServiceImpl<SickblhdrMapper, Sickblhdr> implements SickblhdrService {

    @Autowired
    public SickblhdrMapper sickblhdrMapper;

    //药品接口
    @Autowired
    private SickbldtlMapper sickbldtlMapper;

    @Override
    public int deleteOK(String id) {
        return sickblhdrMapper.deleteOK(id);
    }

    @Override
    public int insertSelective(Sickblhdr sickblhdr) {
        return sickblhdrMapper.insertSelective(sickblhdr);
    }

    @Override
    public int addRegimenList(List<SickbldtlRequest> sickbldtlRequest) {
        return 0;
    }

    @Override
    public int insertDTsickbldtl(Sickbldtl dtsickbldtl) {
        return sickbldtlMapper.insertSelective(dtsickbldtl);
    }

    @Override
    public int updateDTsickbldtl(Sickblhdr dtsickbldtl) {
        return 0;
    }

    @Override
    public int deleteDTsickbldtl(String sickguid) {
        return sickbldtlMapper.deleteDTsickbldtl(sickguid);
    }
}
