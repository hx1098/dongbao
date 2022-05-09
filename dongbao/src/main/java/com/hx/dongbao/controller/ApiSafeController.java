package com.hx.dongbao.controller;


import com.hx.dongbao.annotion.TokenCheck;
import com.hx.dongbao.dto.UmsMemberLoginParamDTO;
import com.hx.dongbao.dto.UmsMemberRegisterParamDTO;
import com.hx.dongbao.dto.UmsMemberUpdateDTO;
import com.hx.dongbao.entity.UmsMember;
import com.hx.dongbao.service.UmsMemberService;
import com.hx.dongbao.utils.CheckUtil;
import com.hx.dongbao.utils.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.naming.Name;
import javax.validation.Valid;
import java.util.HashMap;

/**
 * 后台用户表(UmsMember)表控制层
 *
 * @author makejava
 * @since 2022-04-24 20:45:49
 */
@Api(tags = "安全类")
@RestController
@RequestMapping("/safe")
public class ApiSafeController {


    @GetMapping("/hello")
    public String selectOne() {
        return "hello safe";
    }


    @PostMapping("get-test")
    public String getTest(String appId, String sign, String name) {
        HashMap map = new HashMap();
        map.put("appId", appId);
        map.put("name", name);

        String s = CheckUtil.generatorSign(map);
        if (s.equals(sign)) {
            return "通过";
        } else {
            return "不通过";
        }


    }




}
