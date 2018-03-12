/**
 * projectName: GZYUN
 * fileName: HealthDictEnteryServiceImpl.java
 * packageName: com.gzsys.yun.service.impl
 * date: 2018-01-31 22:06
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.modules.yun.entity.HealthDictEntery;
import com.gzsys.modules.yun.mapper.HealthDictEnteryMapper;
import com.gzsys.modules.yun.response.HealthDictEnteryRespones;
import com.gzsys.modules.yun.service.HealthDictEnteryService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealthDictEnteryServiceImpl
 * @packageName: com.gzsys.yun.service.impl
 * @description:
 * @data: 2018-01-31 22:06
 **/
@Service
public class HealthDictEnteryServiceImpl extends ServiceImpl<HealthDictEnteryMapper, HealthDictEntery> implements HealthDictEnteryService {

	@Autowired
	private HealthDictEnteryMapper healthDictEnteryMapper;
	
	@Override
	public List<HealthDictEnteryRespones> queryDictEnteryByTypeCode(String code) {
		List<HealthDictEnteryRespones> dictEnteryList = new ArrayList<HealthDictEnteryRespones>();
		if(StringUtils.isNotBlank(code)){
			dictEnteryList = healthDictEnteryMapper.queryDictEnteryByTypeCode(code);
		}
		return dictEnteryList;
	}

}
