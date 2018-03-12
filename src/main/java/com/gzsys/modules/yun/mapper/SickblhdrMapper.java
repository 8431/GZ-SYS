package com.gzsys.modules.yun.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gzsys.modules.yun.entity.Sickblhdr;
import org.apache.ibatis.annotations.Param;

public interface SickblhdrMapper extends BaseMapper<Sickblhdr> {

    /**
     * 根据主键删除病历_物理删除
     * @param guid
     * @return
     */
    int deleteOK(@Param("guid") String guid);

    int insertSelective(Sickblhdr record);

}
