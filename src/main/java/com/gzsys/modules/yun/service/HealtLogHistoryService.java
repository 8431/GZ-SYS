/**
 * projectName: gzsys
 * fileName: HealtLogHistoryService.java
 * packageName: com.gzsys.yun.service
 * date: 2018-01-31 21:59
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service;

import com.baomidou.mybatisplus.service.IService;
import com.gzsys.modules.yun.entity.HealtLogHistory;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealtLogHistoryService
 * @packageName: com.gzsys.yun.service
 * @description:
 * @data: 2018-01-31 21:59
 **/
public interface HealtLogHistoryService extends IService<HealtLogHistory> {
 
	public boolean insert(HealtLogHistory bean) ;
}
