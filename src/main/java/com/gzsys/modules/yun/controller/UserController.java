package com.gzsys.modules.yun.controller;

import javax.annotation.Resource;
import javax.validation.Validator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzsys.common.base.controller.BaseController;
import com.gzsys.common.util.CommonException;
import com.gzsys.common.util.JSONResult;
import com.gzsys.common.util.ResultModel;
import com.gzsys.common.util.SimpleCode;
import com.gzsys.common.util.TokenModel;
import com.gzsys.modules.yun.entity.UserLogin;
import com.gzsys.modules.yun.response.LoginUserReqeust;
import com.gzsys.modules.yun.response.RegisterUserReqeust;
import com.gzsys.modules.yun.service.TokenManager;
import com.gzsys.modules.yun.service.UserLoginService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(value = "/api/user")
@Api(value = "用户体系接口", description = "sff")
public class UserController extends BaseController {
	public static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	Validator validator;
	@Autowired
	private TokenManager tokenManager;
	@Resource
	private UserLoginService userLoginService;

	@ApiOperation(value = "登录", httpMethod = "POST" )
	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	@ApiImplicitParams({
			@ApiImplicitParam(name = "identifier", value = "手机号", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "certificate", value = "密码", required = false, dataType = "String", paramType = "query"), })
	@ResponseBody
	public JSONResult<TokenModel> loginUser(@RequestBody(required = false) LoginUserReqeust loginUserReqeust) {
		UserLogin userLogin = null;
		JSONResult<TokenModel> result;
		try {
			if (validates(validator, loginUserReqeust) != null) {
				return new JSONResult<TokenModel>(SimpleCode.ERROR.getCode(), validates(validator, loginUserReqeust));
			}
			userLogin = userLoginService.loginUser(loginUserReqeust);

		} catch (CommonException e) {
			LOGGER.error(e);
			result = new JSONResult<TokenModel>(e.getCode(),e.getDesc());
			return result;
		}
		// 生成一个token，保存用户登录状态
		TokenModel model = tokenManager.createToken(userLogin.getId(),userLogin.getIdentifier());
		result = new JSONResult<TokenModel>(SimpleCode.SUCCESS, model);
		return result;
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	@ApiOperation("用户注册")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "identifier", value = "手机号", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "certificate", value = "密码", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "userName", value = "用户名", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "idCard", value = "身份证号", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "medicalCard", value = "医保卡", required = false, dataType = "String", paramType = "query"),
			@ApiImplicitParam(name = "referralCode", value = "推荐码", required = false, dataType = "String", paramType = "query"), })
	@ResponseBody
	public JSONResult<Boolean> registerUser(@RequestBody(required = false) RegisterUserReqeust req) {
		JSONResult<Boolean> result;
		Boolean flag = false;
		try {
			if (validates(validator, req) != null) {
				return new JSONResult<Boolean>(SimpleCode.ERROR.getCode(), validates(validator, req));
			}
			flag = userLoginService.registerUser(req);

		} catch (CommonException e) {
			LOGGER.error(e);
			result = new JSONResult<Boolean>(e.getCode(),e.getDesc());
			return result;
		}
		result = new JSONResult<Boolean>(SimpleCode.SUCCESS, flag);
		return result;
	}

	/**
	 * @author
	 * @Describe 根据手机号发送验证码
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/sendAuthCode", method = RequestMethod.POST)
	@ApiOperation("发送手机验证码")
	@ResponseBody
	public JSONResult<String> sendAuthCode(@ApiParam(value = "手机号", required = true) @RequestParam String phone) {
		String authCode = null;
		JSONResult<String> result;
		try {
			authCode = userLoginService.sendAuthCode(phone);
		} catch (CommonException e) {
			return new JSONResult(e.getCode(), e.getDesc());
		}
		result = new JSONResult<String>(SimpleCode.SUCCESS, authCode);
		return result;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.DELETE)
	@ApiOperation(value = "退出登录")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "authorization", value = "authorization", required = true, dataType = "string", paramType = "header"), })
	public ResponseEntity<ResultModel> logout(@ApiParam(value = "用户ID", required = true) @RequestParam String id) {
		tokenManager.deleteToken(id);
		return new ResponseEntity<>(ResultModel.ok(), HttpStatus.OK);
	}
	
	/**
	 * 忘记密码-发送验证码
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/sendAuthCodeForgetPWD", method = RequestMethod.POST)
	@ApiOperation("忘记密码-发送手机验证码")
	@ResponseBody
	public JSONResult<String> sendAuthCodeForgetPWD(@ApiParam(value = "手机号", required = true) @RequestParam String phone) {
		String authCode = null;
		JSONResult<String> result;
		try {
			authCode = userLoginService.sendAuthCodeForgetPWD(phone);
		} catch (CommonException e) {
			return new JSONResult<String>(e.getCode(), e.getDesc());
		}
		result = new JSONResult<String>(SimpleCode.SUCCESS, authCode);
		return result;
	}
	
	/**
	 * 忘记密码-修改密码
	 * @param phone
	 * @return
	 */
	@RequestMapping(value = "/forgetPWD", method = RequestMethod.POST)
	@ApiOperation("忘记密码-修改密码")
	@ResponseBody
	public JSONResult<Boolean> forgetPWD(@ApiParam(value = "手机号", required = true) @RequestParam String identifier,
										@ApiParam(value = "密码", required = true) @RequestParam String certificate) {
		JSONResult<Boolean> result;
		Boolean flag = false;
		try {
			RegisterUserReqeust req = new RegisterUserReqeust();
			req.setIdentifier(identifier);
			req.setCertificate(certificate);
			flag = userLoginService.forgetPWD(req);
		} catch (CommonException e) {
			LOGGER.error(e);
			result = new JSONResult<Boolean>(e.getCode(),e.getDesc());
			return result;
		}
		result = new JSONResult<Boolean>(SimpleCode.SUCCESS, flag);
		return result;
	}
	
}
