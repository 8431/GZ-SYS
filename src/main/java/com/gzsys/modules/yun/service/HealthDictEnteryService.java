/**
 * projectName: gzsys
 * fileName: HealthDictEnteryService.java
 * packageName: com.gzsys.yun.service
 * date: 2018-01-31 21:58
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.gzsys.modules.yun.entity.HealthDictEntery;
import com.gzsys.modules.yun.response.HealthDictEnteryRespones;

/**
 * @version: V1.0
 * @author: fendo
 * @className: HealthDictEnteryService
 * @packageName: com.gzsys.yun.service
 * @description:
 * @data: 2018-01-31 21:58
 **/
public interface HealthDictEnteryService extends IService<HealthDictEntery> {
	
	/**
	 * 根据数据字典类型代码查询字典键值（1科室、2医生职称）
	 * @param code
	 * @return
	 */
	public List<HealthDictEnteryRespones> queryDictEnteryByTypeCode(String code);

}
