package com.hx.dongbao.controller;


import com.hx.dongbao.dto.UmsMemberLoginParamDTO;
import com.hx.dongbao.dto.UmsMemberRegisterParamDTO;
import com.hx.dongbao.dto.UmsMemberUpdateDTO;
import com.hx.dongbao.entity.UmsMember;
import com.hx.dongbao.service.UmsMemberService;
import com.hx.dongbao.utils.ResultWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * 后台用户表(UmsMember)表控制层
 *
 * @author makejava
 * @since 2022-04-24 20:45:49
 */
@Api(tags = "用户")
@RestController
@RequestMapping("user-member")
public class UmsMemberController {
    /**
     * 服务对象
     */
    @Resource
    private UmsMemberService umsMemberService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UmsMember selectOne(Long id) {
        return this.umsMemberService.queryById(id);
    }

    /**
     * 注册：传入验证码信息
     * @param umsMemberRegisterParamDTO
     * @return
     */
    @ApiOperation("注册")
    @PostMapping("/register")
    public ResultWrapper register(@RequestBody @Valid UmsMemberRegisterParamDTO umsMemberRegisterParamDTO){

        return umsMemberService.register(umsMemberRegisterParamDTO);
    }

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResultWrapper login(@RequestBody @Valid UmsMemberLoginParamDTO umsMemberLoginParamDTO){

        return umsMemberService.login(umsMemberLoginParamDTO);
    }

    @ApiOperation("登录")
    @PostMapping("/edit")
    public ResultWrapper edit(@RequestBody  UmsMemberUpdateDTO umsMemberUpdateDTO){
        int edit = umsMemberService.edit(umsMemberUpdateDTO);
        return ResultWrapper.builder().data("1").code(200).build();
    }

}
