package com.hx.dongbao.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.io.Serializable;

/**
 * 后台用户表(UmsMember)实体类
 *
 * @author makejava
 * @since 2022-04-24 20:45:45
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsMember implements Serializable {

    private static final long serialVersionUID = 627411431785627895L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String username;

    private String password;
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

    /**
     * 创建时间
     */

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
    /**
     * 最后登录时间
     */
    private Date loginTime;
    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;

}
