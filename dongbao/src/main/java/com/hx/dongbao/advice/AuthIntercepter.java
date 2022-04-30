package com.hx.dongbao.advice;

import com.hx.dongbao.annotion.TokenCheck;
import com.hx.dongbao.utils.JwtUtil;
import jdk.nashorn.internal.ir.ReturnNode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/30 9:50
 * @description
 * @editUser hx
 * @editTime 2022/4/30 9:50
 * @editDescription  拦截所有的带有tokenChecked的注解
 */
@Slf4j
public class AuthIntercepter implements HandlerInterceptor {

    

    /**
     * 预处理的
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("tokenChecked 拦截器进来了.....");
        String token = request.getHeader("token");

        if (StringUtils.isBlank(token)) {
            throw new Exception("token 为空!");
        }

        //将方法传进来, 判断是否有TokenCheck的注解,
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(TokenCheck.class)) {
            //获取该注解上的数据, 为true 就去校验token, 不为true就不校验
            TokenCheck annotation = method.getAnnotation(TokenCheck.class);
            if (annotation.required()) {
                try {
                    JwtUtil.parseToken(token);
                    return true;
                } catch (Exception e) {
                    throw new LoginException("token异常!");
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
