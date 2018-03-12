/**
 * projectName: GZYUN
 * fileName: UserLoginServiceImpl.java
 * packageName: com.gzsys.yun.service.impl
 * date: 2018-01-31 22:08
 * copyright(c) 2017-2020 xxx公司
 */
package com.gzsys.modules.yun.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.gzsys.common.aop.LogType;
import com.gzsys.common.util.CommonException;
import com.gzsys.common.util.Des;
import com.gzsys.common.util.MD5Utils;
import com.gzsys.common.util.MobileCode;
import com.gzsys.common.util.RegexUtils;
import com.gzsys.common.util.UUIDTool;
import com.gzsys.common.util.UserRoleEnum;
import com.gzsys.common.util.UserTypeEnum;
import com.gzsys.modules.yun.entity.HealtLogHistory;
import com.gzsys.modules.yun.entity.UserBase;
import com.gzsys.modules.yun.entity.UserLogin;
import com.gzsys.modules.yun.mapper.HealtLogHistoryMapper;
import com.gzsys.modules.yun.mapper.InspectionItemsMapper;
import com.gzsys.modules.yun.mapper.UserBaseMapper;
import com.gzsys.modules.yun.mapper.UserLoginMapper;
import com.gzsys.modules.yun.response.LoginUserReqeust;
import com.gzsys.modules.yun.response.RegisterUserReqeust;
import com.gzsys.modules.yun.service.HealtLogHistoryService;
import com.gzsys.modules.yun.service.UserLoginService;

/**
 * @version: V1.0
 * @author: sff
 * @className: UserLoginServiceImpl
 * @packageName: com.gzsys.yun.service.impl
 * @description:
 * @data: 2018-01-31 22:08
 **/
@Service
public class UserLoginServiceImpl extends ServiceImpl<UserLoginMapper, UserLogin> implements UserLoginService {
	@Autowired
	public InspectionItemsMapper inspectionItemsMapper;
	@Autowired
	public HealtLogHistoryMapper healtLogHistoryMapper;
	@Autowired
	HealtLogHistoryService healtLogHistoryService;
	@Autowired
	UserLoginMapper userLoginMapper;
	@Autowired
	UserBaseMapper userBaseMapper;
	 private final String key="0c286e57b6c74c4c8be191ea71153889";
	@Override
	public String sendAuthCode(String phone) throws CommonException {
		long authCode = 0;
		String md5AuthCode=null;
		if (!RegexUtils.isMobile(phone)) {
			throw new CommonException("USER_COM001", "请输入正确的手机号!!");
		}
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("identity_type", "1");// 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪
		columnMap.put("identifier", phone);
		columnMap.put("user_type", "1");// 1患者2医生
		List<UserLogin> user = baseMapper.selectByMap(columnMap);
		if (user.isEmpty()) {
			HealtLogHistory healtLog = new HealtLogHistory();
			healtLog.setState("1");
			healtLog.setLogLevel(LogType.INFO.toString());
			healtLog.setLogOp(phone);
			healtLog.setLogType("001");
			int count = healtLogHistoryMapper.countByAuthCode(healtLog);
			if (count < 10) {
				authCode = Math.round(Math.floor((Math.random() * 9 + 1) * 100000)); // 验证码
				// 请求内容 您的验证码是123456，5分钟内有效。为了您的账号安全，请勿告知他人
				String content = "您的短信验证码是：" + authCode + "，5分钟内有效。为了您的账号安全，请勿告知他人。";
				try {
					MobileCode.sendAuthCode(phone, content);
					healtLogHistoryService.insert(healtLog);
					md5AuthCode=Des.encrypt(authCode+"",key);
				} catch (Exception e) {
					throw new CommonException("USER_COM003", "发送短信验证码异常!");
				}
			} else {
				throw new CommonException("USER_COM004", "验证码次数达到上限");
			}
		} else {
			throw new CommonException("USER_COM002", "手机号已经注册过,请更换手机号注册!");
		}
		return md5AuthCode;
	}

	/**
	 * 用户注册
	 */
	@Override
	public boolean registerUser(RegisterUserReqeust req) throws CommonException {
		boolean flag = false;
		if (!RegexUtils.isMobile(req.getIdentifier())) {
			throw new CommonException("USER_COM001", "请输入正确的手机号!!");
		}
		if (!RegexUtils.isIDCard(req.getIdCard())) {
			throw new CommonException("USER_COM005", "请输入正确的身份证号!!");
		}
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("identity_type", "1");// 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪
		columnMap.put("identifier", req.getIdentifier());// 手机号
		columnMap.put("user_type", "1");// 1患者2医生
		List<UserLogin> user = baseMapper.selectByMap(columnMap);
		if (user.isEmpty()) {
			UserLogin userLogin = new UserLogin();
			userLogin.setId(UUIDTool.getUUID());
			userLogin.setIdentifier(req.getIdentifier());
			userLogin.setIdentityType(UserTypeEnum.ONE.getValue().toString());
			userLogin.setUserType("1");
			userLogin.setCertificate(MD5Utils.getMD5(req.getCertificate()));
			int i = userLoginMapper.insert(userLogin);
			if (i > 0) {
				UserBase userBase = new UserBase();
				userBase.setId(UUIDTool.getUUID());
				userBase.setUserRole(UserRoleEnum.ONE.getValue().toString());
				userBase.setUserName(req.getUserName());
				userBase.setIdCard(req.getIdCard());
				userBase.setMedicalCard(req.getMedicalCard());
				userBase.setReferralCode(req.getReferralCode());
				int count = userBaseMapper.insert(userBase);
				if (count > 0) {
					flag = true;
				}
			}

		} else {
			throw new CommonException("USER_COM001", "手机号已经注册过!");
		}
		return flag;
	}

	@Override
	public UserLogin loginUser(LoginUserReqeust req) throws CommonException {
		// 获取密码输入错误次数
		HealtLogHistory healtLog = new HealtLogHistory();
		healtLog.setState("1");
		healtLog.setLogLevel(LogType.INFO.toString());
		healtLog.setLogOp(req.getIdentifier());
		healtLog.setLogType("002");
		int count = healtLogHistoryMapper.countByAuthCode(healtLog);
		Calendar todayEnd = Calendar.getInstance();
		todayEnd.set(Calendar.HOUR_OF_DAY, 23);
		todayEnd.set(Calendar.MINUTE, 59);
		todayEnd.set(Calendar.SECOND, 59);
		todayEnd.set(Calendar.MILLISECOND, 999);
		Date end = todayEnd.getTime();
		if (count > 5 && end.getTime() >= new Date().getTime()) {
			throw new CommonException("USER_COM007", "一个小时内验证不通过大于5次，当天24点前不能登录！");
		}
		Map<String, Object> columnMap = new HashMap<String, Object>();
		UserLogin userlogin = new UserLogin();
		columnMap.put("identity_type", "1");// 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪
		columnMap.put("identifier", req.getIdentifier());// 手机号
		columnMap.put("certificate", MD5Utils.getMD5(req.getCertificate()));// 密码
		columnMap.put("user_type", "1");// 1患者2医生
		List<UserLogin> user = baseMapper.selectByMap(columnMap);
		if (user.isEmpty()) {
			healtLog.setLogOperation("用户名和密码验证错误");
			healtLogHistoryService.insert(healtLog);
			throw new CommonException("USER_COM006", "用户名或者密码错误!");

		} else {
			userlogin = user.get(0);
		}
		return userlogin;
	}

	@Override
	public String sendAuthCodeForgetPWD(String phone) throws CommonException {
		long authCode = 0;
		String md5AuthCode=null;
		if (!RegexUtils.isMobile(phone)) {
			throw new CommonException("USER_COM001", "请输入正确的手机号!!");
		}
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("identity_type", "1");// 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪
		columnMap.put("identifier", phone);
		columnMap.put("user_type", "1");// 1患者2医生
		List<UserLogin> user = baseMapper.selectByMap(columnMap);
		if (!user.isEmpty()) {
			HealtLogHistory healtLog = new HealtLogHistory();
			healtLog.setState("1");
			healtLog.setLogLevel(LogType.INFO.toString());
			healtLog.setLogOp(phone);
			healtLog.setLogType("001");
			int count = healtLogHistoryMapper.countByAuthCode(healtLog);
			if (count < 10) {
				authCode = Math.round(Math.floor((Math.random() * 9 + 1) * 100000)); // 验证码
				// 请求内容 您的验证码是123456，5分钟内有效。为了您的账号安全，请勿告知他人
				String content = "您的短信验证码是：" + authCode + "，5分钟内有效。为了您的账号安全，请勿告知他人。";
				try {
					MobileCode.sendAuthCode(phone, content);
					healtLogHistoryService.insert(healtLog);
					md5AuthCode=Des.encrypt(authCode+"",key);
				} catch (Exception e) {
					throw new CommonException("USER_COM003", "发送短信验证码异常!");
				}
			} else {
				throw new CommonException("USER_COM004", "验证码次数达到上限");
			}
		} else {
			throw new CommonException("USER_COM002", "手机号未注册!");
		}
		return md5AuthCode;
	}

	@Override
	public boolean forgetPWD(RegisterUserReqeust req) throws CommonException {
		boolean flag = false;
		if (!RegexUtils.isMobile(req.getIdentifier())) {
			throw new CommonException("USER_COM001", "请输入正确的手机号!!");
		}
		if(!RegexUtils.isPassword(req.getCertificate())){
			throw new CommonException("USER_COM002", "密码长度只能在6-16位之间!!");
		}
		Map<String, Object> columnMap = new HashMap<String, Object>();
		columnMap.put("identity_type", "1");// 1手机号 2邮箱 3用户名 4qq 5微信 6腾讯微博 7新浪
		columnMap.put("identifier", req.getIdentifier());// 手机号
		columnMap.put("user_type", "1");// 1患者2医生
		List<UserLogin> user = baseMapper.selectByMap(columnMap);
		if (!user.isEmpty()) {
			UserLogin userLogin = user.get(0);
			userLogin.setCertificate(MD5Utils.getMD5(req.getCertificate()));
			userLogin.setCreateTime(null);
			userLogin.setUpdateTime(new Date());
			int i = userLoginMapper.updateById(userLogin);
			if (i > 0) {
				flag = true;
			}

		} else {
			throw new CommonException("USER_COM001", "手机号未注册!");
		}
		return flag;
	}

}
