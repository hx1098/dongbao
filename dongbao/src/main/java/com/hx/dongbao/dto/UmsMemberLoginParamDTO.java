package com.hx.dongbao.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Size;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/25 20:23
 * @description
 * @editUser hx
 * @editTime 2022/4/25 20:23
 * @editDescription
 */
@Data
@ToString
@ApiModel(value = "用户信息")
public class UmsMemberLoginParamDTO {

    private String username;

    private String password;


}