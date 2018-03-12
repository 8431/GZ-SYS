package com.gzsys.common.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.gzsys.common.util.UUIDTool;
import com.gzsys.modules.yun.entity.HealtLogHistory;
import com.gzsys.modules.yun.mapper.HealtLogHistoryMapper;

@Component
@Aspect
public class LogAspect {

	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);
	@Autowired
	HealtLogHistoryMapper healtLogHistoryMapper;

	/**
	 * 切入点
	 */
	@Pointcut("@annotation(com.gzsys.common.aop.ServiceLog) ")
	public void entryPoint() {
		// 无需内容
	}

	@Before("entryPoint()")
	public void before(JoinPoint joinPoint) {
		log.info("=====================开始执行前置通知==================");
		try {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
					.getRequestAttributes();
			HttpServletRequest request = attributes.getRequest();
			String remoteAddr = getIpAddr(request);
			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();
			Class<?> targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String operation = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class<?>[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						operation = method.getAnnotation(ServiceLog.class).operation();// 操作人
						break;
					}
				}
			}
			HealtLogHistory bean = new HealtLogHistory();
			for (Object arg : arguments) {
				if (arg instanceof HealtLogHistory) {
					bean = (HealtLogHistory) arg;
					bean.setId(UUIDTool.getUUID());
					bean.setLogIp(remoteAddr);
					bean.setLogObject(targetName);
					bean.setLogMethod(methodName);
					bean.setLogLevel(LogType.INFO.toString());
					bean.setLogMessageDesc(operation);
					healtLogHistoryMapper.insert(bean);
				}
			}
			log.info("=====================执行前置通知结束==================");
		} catch (Throwable e) {
			log.info("around " + joinPoint + " with exception : " + e.getMessage());
		}

	}

	// 获取客户端IP
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
