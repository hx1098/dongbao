package com.hx.dongbao.advice;

import com.hx.dongbao.utils.ResultWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.LoginException;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/30 10:52
 * @description
 * @editUser hx
 * @editTime 2022/4/30 10:52
 * @editDescription  用户可以进行自定义异常....
 */
@RestControllerAdvice
public class GlobalExcepetionHandle {

    @ExceptionHandler(ArithmeticException.class)
    public ResultWrapper customException() {
        return ResultWrapper.builder().code(301).msg("统一异常").build();
    }

    @ExceptionHandler(LoginException.class)
    public ResultWrapper loginExcetion(Exception e) {
        return ResultWrapper.getFailBuilder().msg(e.getMessage()).build();
    }
}
