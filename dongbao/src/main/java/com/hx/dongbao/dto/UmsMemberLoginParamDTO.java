package com.hx.dongbao.dto;

import io.swagger.annotations.ApiModel;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;
import lombok.Getter;
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
@ApiModel(value = "用户信息")
public class UmsMemberLoginParamDTO {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}