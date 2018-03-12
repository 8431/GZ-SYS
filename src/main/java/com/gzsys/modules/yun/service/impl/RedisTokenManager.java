package com.gzsys.modules.yun.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import com.gzsys.common.jwt.JwtUtils;
import com.gzsys.common.util.SystemConstant;
import com.gzsys.common.util.TokenModel;
import com.gzsys.modules.yun.service.TokenManager;

@Component
public class RedisTokenManager implements TokenManager {

	private RedisTemplate<String, String> redis;

	@Autowired
	public void setRedis(RedisTemplate<String, String> redis) {
		this.redis = redis;
		// 泛型设置成Long后必须更改对应的序列化方案
		redis.setKeySerializer(new JdkSerializationRedisSerializer());
	}

	public TokenModel createToken(String userId,String userName) {
		String token = JwtUtils.createJWT(userId, userName, SystemConstant.JWT_TTL);
		TokenModel model = new TokenModel(userId, token);
		// 存储到redis并设置过期时间
		redis.boundValueOps(userId).set(token, SystemConstant.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return model;
	}

	public TokenModel getToken(String authentication) {
		if (authentication == null || authentication.length() == 0) {
			return null;
		}
		String userId = null;
		try {
			userId = JwtUtils.parseJWT(authentication).getId().toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new TokenModel(userId, authentication);
	}

	public boolean checkToken(TokenModel model) {
		if (model == null) {
			return false;
		}
		String token = redis.boundValueOps(model.getUserId()).get();
		if (token == null || !token.equals(model.getToken())) {
			return false;
		}
		// 如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redis.boundValueOps(model.getUserId()).expire(SystemConstant.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
		return true;
	}

	public void deleteToken(String userId) {
		redis.delete(userId);
	}
}
