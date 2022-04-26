package com.hx.dongbao.response;

import com.hx.dongbao.entity.UmsMember;
import lombok.Data;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/26 20:55
 * @description
 * @editUser hx
 * @editTime 2022/4/26 20:55
 * @editDescription
 */
@Data
public class UserMemberLoginResponse {
    private String token;
    private UmsMember umsMember;
}
