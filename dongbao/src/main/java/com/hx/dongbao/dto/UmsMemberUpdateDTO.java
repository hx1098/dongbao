package com.hx.dongbao.dto;

import lombok.Data;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/26 21:00
 * @description
 * @editUser hx
 * @editTime 2022/4/26 21:00
 * @editDescription
 */
@Data
public class UmsMemberUpdateDTO {

    private Long id;

    private String username;
    /**
     * 头像
     */
    private String icon;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 备注信息
     */
    private String note;

}
