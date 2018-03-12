/**
 * projectName: GZYUN
 * fileName: HealtLogHistoryServiceImpl.java
 * packageName: com.gzsys.yun.service.impl
 * date: 2018-01-31 22:07
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.common.aop.ServiceLog;
import com.gzsys.modules.yun.entity.HealtLogHistory;
import com.gzsys.modules.yun.mapper.HealtLogHistoryMapper;
import com.gzsys.modules.yun.service.HealtLogHistoryService;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealtLogHistoryServiceImpl
 * @packageName: com.gzsys.yun.service.impl
 * @description:
 * @data: 2018-01-31 22:07
 **/
@Service
public class HealtLogHistoryServiceImpl extends ServiceImpl<HealtLogHistoryMapper, HealtLogHistory> implements HealtLogHistoryService {
	@ServiceLog(operation = "日志新增。。。。。")
	@Override
	public boolean insert(HealtLogHistory bean) {
		return false;
	}
}
