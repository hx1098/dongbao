package com.hx.dongbao.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

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
public class UmsMemberRegisterParamDTO {

    @Size(min = 1, max = 8, message = "用户名长度在1-8之间")
    @NotBlank(message = "用户名不能为空")
    private String username;

    private String password;

    private String icon;

    @Email
    private String email;

    private String nickName;
}