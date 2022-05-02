package com.hx.dongbao.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import com.wf.captcha.ArithmeticCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/30 13:59
 * @description
 * @editUser hx
 * @editTime 2022/4/30 13:59
 * @editDescription  验证码
 */
@Api("happyCode")
@Slf4j
@RestController
@RequestMapping("/easy")
public class EasyCapchaController {

    public static final String codeKey = "verifyCode";

    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        try {
            //基本的
            //CaptchaUtil.out(request, response);

            //算数类型的
            ArithmeticCaptcha arithmeticCaptcha = new ArithmeticCaptcha(200, 50);
            arithmeticCaptcha.setLen(3);
            CaptchaUtil.out(arithmeticCaptcha,request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/vertify")
    public String vertify(String verifyCode, HttpServletRequest request) {
        log.info("vertify::verifyCode = [{}]", verifyCode);
        //忽略大小写
        Boolean aBoolean = CaptchaUtil.ver(verifyCode, request);
        if (aBoolean) {
            HappyCaptcha.remove(request);
            return "通过";
        }
        return "不通过";
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation("generator-redis")
    @GetMapping("/generator-redis")
    public void generatorCodeRedis(HttpServletRequest request, HttpServletResponse response) {
        try {
            SpecCaptcha se = new SpecCaptcha(100, 50);
            String text = se.text();
            log.info("验证码是: ::text = [{}]", text);
            stringRedisTemplate.opsForValue().set("captchaCode", text);

            CaptchaUtil.out(se,request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("vertifyRedis")
    @GetMapping("/vertifyRedis")
    public String vertifyRedis(String verifyCode, HttpServletRequest request) {
        log.info("vertify::verifyCode = [{}]", verifyCode);
        //忽略大小写
        String captchaCode = stringRedisTemplate.opsForValue().get("captchaCode");
        if (captchaCode.equals(verifyCode)) {
            HappyCaptcha.remove(request);
            return "通过";
        }
        return "不通过";
    }


}

