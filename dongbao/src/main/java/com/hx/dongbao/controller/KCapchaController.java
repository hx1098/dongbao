package com.hx.dongbao.controller;

import com.baomidou.kaptcha.Kaptcha;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/30 13:59
 * @description
 * @editUser hx
 * @editTime 2022/4/30 13:59
 * @editDescription 验证码
 */
@Api("kcaptaher")
@Slf4j
@RestController
@RequestMapping("/kcaptaher")
public class KCapchaController {

    @Autowired
    private Kaptcha kaptcha;


    @GetMapping("/render")
    public void render() {

        String render = kaptcha.render();
        log.info("render::[{}]",render);
    }

    @PostMapping("/valid")
    public String validDefaultTime(@RequestParam String code) {
        if (kaptcha.validate(code)) {
            return "通过";
        }
        return "不通过";
    }

    @PostMapping("/validTime")
    public void validCustomTime(@RequestParam String code) {
        //校验的
        kaptcha.validate(code, 60);
    }


}

