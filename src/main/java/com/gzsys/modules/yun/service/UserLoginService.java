/**
 * projectName: gzsys
 * fileName: UserLoginService.java
 * packageName: com.gzsys.yun.service
 * date: 2018-01-31 21:59
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service;

import com.baomidou.mybatisplus.service.IService;
import com.gzsys.common.util.CommonException;
import com.gzsys.modules.yun.entity.UserLogin;
import com.gzsys.modules.yun.response.LoginUserReqeust;
import com.gzsys.modules.yun.response.RegisterUserReqeust;

/**
 * @version: V1.0
 * @author: fendo
 * @className: UserLoginService
 * @packageName: com.gzsys.yun.service
 * @description:
 * @data: 2018-01-31 21:59
 **/
public interface UserLoginService extends IService<UserLogin> {
	String sendAuthCode (String phone) throws CommonException;
	boolean registerUser(RegisterUserReqeust req)throws CommonException;
	UserLogin loginUser (LoginUserReqeust req)throws CommonException;
	
	String sendAuthCodeForgetPWD(String phone) throws CommonException;
	boolean forgetPWD(RegisterUserReqeust req) throws CommonException;
	
}
