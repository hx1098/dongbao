package com.hx.dongbao.controller;

import com.hx.dongbao.utils.JCaptchaUtil;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import com.ramostear.captcha.support.CaptchaType;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
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
@Slf4j
@RestController
@RequestMapping("/happy")
public class HappyCapchaController {

    public static final String codeKey = "verifyCode";

    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        HappyCaptcha.require(request, response)
                .style(CaptchaStyle.ANIM)
                .type(CaptchaType.ARITHMETIC)
                .build().finish();
    }




    @GetMapping("/vertify")
    public String vertify(String verifyCode, HttpServletRequest request) {
        log.info("vertify::verifyCode = [{}]",verifyCode);
        //忽略大小写
        Boolean aBoolean = HappyCaptcha.verification(request, verifyCode, true);
        if (aBoolean) {
            HappyCaptcha.remove(request);
            return "通过";
        }
        return "不通过";
    }
}
