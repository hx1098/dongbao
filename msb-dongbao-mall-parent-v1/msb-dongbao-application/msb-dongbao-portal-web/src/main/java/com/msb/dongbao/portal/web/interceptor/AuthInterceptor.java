package com.msb.dongbao.portal.web.interceptor;

import com.msb.dongbao.common.base.annotations.TokenCheck;
import com.msb.msbdongbaocommonutil.JwtUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 马士兵教育:chaopengfei
 * @date 2021/1/27
 */
public class AuthInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		System.out.println("拦截器进入");

		String token = request.getHeader("token");
		if (StringUtils.isBlank(token)){
//			throw new LoginException("token 为空");
			return false;
		}

		HandlerMethod handlerMethod = (HandlerMethod)handler;
		Method method = handlerMethod.getMethod();

		if (method.isAnnotationPresent(TokenCheck.class)){
			TokenCheck annotation = method.getAnnotation(TokenCheck.class);
			if (annotation.required()){
				// 校验token
				try {
					JwtUtil.parseToken(token);
					return true;
				}catch (Exception e){
					return false;
				}

			}
		}


		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
