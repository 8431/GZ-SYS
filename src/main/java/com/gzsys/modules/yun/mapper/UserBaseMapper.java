/*
* UserBaseMapper.java
* Copyright(C) 2017-2020 贯众健康公司
* @date 2018-01-31
*/
package com.gzsys.modules.yun.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.request.DoctorRequest;
import com.gzsys.modules.yun.request.UserBaseRequest;

public interface UserBaseMapper extends BaseMapper<UserBase> {
	
	/**
	 * 查询医生列表
	 * @param page
	 * @param user
	 * @return
	 */
	List<UserBase> queryPageDoctorList(Pagination page,UserBaseRequest user);

	/**
	 * 查询医生信息列表
	 * @param page
	 * @param doctorRequest
	 * @return
	 */
	List<Map<String,Object>> queryPageDoctorInformationList(Pagination page, DoctorRequest doctorRequest);

}