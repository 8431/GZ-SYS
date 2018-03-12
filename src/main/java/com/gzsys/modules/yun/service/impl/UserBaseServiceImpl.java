/**
 * projectName: GZYUN
 * fileName: UserBaseServiceImpl.java
 * packageName: com.gzsys.yun.service.impl
 * date: 2018-01-31 22:08
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import com.gzsys.modules.yun.request.DoctorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.mapper.UserBaseMapper;
import com.gzsys.modules.yun.request.UserBaseRequest;
import com.gzsys.modules.yun.service.UserBaseService;

import java.util.List;
import java.util.Map;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserBaseServiceImpl
 * @packageName: com.gzsys.yun.service.impl
 * @description:
 * @data: 2018-01-31 22:08
 **/
@Service
public class UserBaseServiceImpl extends ServiceImpl<UserBaseMapper, UserBase> implements UserBaseService {
	
	@Autowired
	private UserBaseMapper userBaseMapper;

	@Override
	public Page<UserBase> queryPageDoctorList(Page<UserBaseRequest> page, UserBaseRequest user) {
		Page<UserBase> resultPage = new Page<UserBase>(page.getCurrent(), page.getSize());
		resultPage.setRecords(userBaseMapper.queryPageDoctorList(resultPage,user));
		return resultPage;
	}

	@Override
	public Page<Map<String,Object>> queryPageDoctorInformationList(Page<DoctorRequest> page, DoctorRequest doctorRequest) {
		Page<Map<String,Object>> resultPage = new Page<Map<String,Object>>();
		resultPage.setRecords(userBaseMapper.queryPageDoctorInformationList(page,doctorRequest));
		return resultPage;
	}

}
