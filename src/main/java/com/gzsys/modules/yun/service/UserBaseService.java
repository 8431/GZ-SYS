/**
 * projectName: gzsys
 * fileName: UserBaseService.java
 * packageName: com.gzsys.yun.service
 * date: 2018-01-31 21:59
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.request.DoctorRequest;
import com.gzsys.modules.yun.request.UserBaseRequest;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserBaseService
 * @packageName: com.gzsys.yun.service
 * @description:
 * @data: 2018-01-31 21:59
 **/
public interface UserBaseService extends IService<UserBase> {
	
	/**
	 * 查询医生列表
	 * @param page
	 * @param user
	 * @return
	 */
	 Page<UserBase> queryPageDoctorList(Page<UserBaseRequest> page,UserBaseRequest user);

	/**
	 * 查询医生信息列表
	 * @param page
	 * @param doctorRequest
	 * @return
	 */
	 Page<Map<String,Object>> queryPageDoctorInformationList(Page<DoctorRequest> page, DoctorRequest doctorRequest);
}
