package com.hx.dongbao.dto;

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
public class UmsMemberRegisterParamDTO {

    @Size(min = 1, max = 8, message = "用户名长度在1-8之间")
    private String username;

    private String password;

    private String icon;

    @Email
    private String email;

    private String nickName;
}