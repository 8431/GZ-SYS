package com.gzsys.modules.yun.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gzsys.modules.yun.entity.Sickbldtl;
import org.apache.ibatis.annotations.Param;

public interface SickbldtlMapper extends BaseMapper<Sickbldtl> {

    int insertSelective(Sickbldtl record);

    /**
     * 根据病历ID删除用药方案
     * @param sickguid
     * @return
     */
    int deleteDTsickbldtl(@Param("sickguid") String sickguid);

}
