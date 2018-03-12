/*
* HealthDictEnteryMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2018-01-31
*/
package com.gzsys.modules.yun.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gzsys.modules.yun.entity.HealthDictEntery;
import com.gzsys.modules.yun.response.HealthDictEnteryRespones;

public interface HealthDictEnteryMapper extends BaseMapper<HealthDictEntery> {
	
	/**
	 * 根据数据字典类型代码查询字典键值
	 * @param code
	 * @return
	 */
	List<HealthDictEnteryRespones> queryDictEnteryByTypeCode(@Param("code") String code);

}