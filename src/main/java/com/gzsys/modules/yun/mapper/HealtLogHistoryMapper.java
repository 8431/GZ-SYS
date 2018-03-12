/*
* HealtLogHistoryMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2018-01-31
*/
package com.gzsys.modules.yun.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.gzsys.modules.yun.entity.HealtLogHistory;

public interface HealtLogHistoryMapper extends BaseMapper<HealtLogHistory> {

	int countByAuthCode(HealtLogHistory data);
	
	int countByPassword(HealtLogHistory data);
}