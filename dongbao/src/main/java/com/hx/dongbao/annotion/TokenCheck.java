package com.hx.dongbao.annotion;

import io.swagger.annotations.Api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hx
 * @createTime 2022/4/30 9:45
 * @option
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenCheck {

    /**
     * 是否校验token, 默认为true
     * @return
     */
    boolean required() default true;



}
