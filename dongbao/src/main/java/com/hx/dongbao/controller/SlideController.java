package com.hx.dongbao.controller;

import com.ramostear.captcha.HappyCaptcha;
import com.sun.xml.internal.bind.v2.TODO;
import com.wf.captcha.ChineseCaptcha;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/30 13:59
 * @description
 * @editUser hx
 * @editTime 2022/4/30 13:59
 * @editDescription  滑块验证码
 */
@Api("滑动验证码")
@Slf4j
@RestController
@RequestMapping("/slide")
public class SlideController {


    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        // todo-repeate 2022/5/3 8:45  需要重新思考
    }

    @GetMapping("/vertify")
    public String vertify(String verifyCode, HttpServletRequest request) {
        log.info("vertify::verifyCode = [{}]", verifyCode);
        // todo-hx 2022/5/3 8:45 需要重新思考
        return null;
    }




}

