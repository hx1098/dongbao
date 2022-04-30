package com.hx.dongbao.controller;

import com.hx.dongbao.utils.VerifyCodeUtil;
import lombok.extern.slf4j.Slf4j;
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
 * @editDescription  验证码
 */
@Slf4j
@RestController
@RequestMapping("/code")
public class VerifyController {

    @GetMapping("/generator")
    public void generatorCode(HttpServletRequest request, HttpServletResponse response) {
        VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
        verifyCodeUtil.generateCode();
        //获取验证码中的code
        String text = verifyCodeUtil.getText();
        log.info("vertify::text = [{}]", text);
        //redisUtial.save(text)

        String codeKey = "abc";
        request.getSession().setAttribute("AppConst.Login.CodeKey", codeKey);
        verifyCodeUtil.writeCodeToRespone(response);
    }

    @GetMapping("/vertify")
    public String vertify(String verifyCode, HttpServletRequest request) {
        log.info("vertify::verifyCode = [{}], request = [{}]",verifyCode, request);

        return null;
    }
}
