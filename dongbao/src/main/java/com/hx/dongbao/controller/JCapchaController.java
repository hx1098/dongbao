package com.hx.dongbao.controller;

import com.hx.dongbao.utils.JCaptchaUtil;
import com.hx.dongbao.utils.VerifyCodeUtil;
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
@RequestMapping("/jcapcha")
public class JCapchaController {

    public static final String codeKey = "verifyCode";

    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getSession().getId();
        BufferedImage bufferedImage = JCaptchaUtil.getService().getImageChallengeForID(id);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        JPEGImageEncoder jpegEncoder = JPEGCodec.createJPEGEncoder(byteArrayOutputStream);

        try {
            jpegEncoder.encode(bufferedImage);
            response.setHeader("Cache-Control","store");
            response.setContentType("image/jpeg");
            //将字节流输出出去
            byte[] bytes = byteArrayOutputStream.toByteArray();
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    @GetMapping("/vertify")
    public String vertify(String verifyCode, HttpServletRequest request) {
        log.info("vertify::verifyCode = [{}]",verifyCode);
        Boolean aBoolean = JCaptchaUtil.getService().validateResponseForID(request.getSession().getId(), verifyCode);
        if (aBoolean) {
            return "通过";
        }
        return "不通过";
    }
}
