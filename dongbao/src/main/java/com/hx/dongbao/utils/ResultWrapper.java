package com.hx.dongbao.utils;

import com.hx.dongbao.enums.StateCodeEnum;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/25 20:21
 * @description
 * @editUser hx
 * @editTime 2022/4/25 20:21
 * @editDescription
 */
@Data
@Builder
public class ResultWrapper<T> implements Serializable {

    // 状态码
    private int code;

    // 提示信息
    private String msg;

    private T data;


    /**
     *  返回成功的包装
     * @return
     */
    public  static ResultWrapper.ResultWrapperBuilder getSuccessBuilder(){
        return ResultWrapper.builder().code(StateCodeEnum.SUCCESS.getCode()).msg(StateCodeEnum.SUCCESS.getMsg());
    }

    public static ResultWrapper.ResultWrapperBuilder getFailBuilder(){
        return ResultWrapper.builder().code(StateCodeEnum.FAIL.getCode()).msg(StateCodeEnum.FAIL.getMsg());
    }
}