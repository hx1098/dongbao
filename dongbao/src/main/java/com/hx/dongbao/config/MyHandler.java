package com.hx.dongbao.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/28 20:09
 * @description
 * @editUser hx
 * @editTime 2022/4/28 20:09
 * @editDescription  自动插入时间， sql执行的时候
 */
@Component
public class MyHandler implements MetaObjectHandler {


    /*必须使用mybatis的api进行插入和更新操作， 我这里并没有使用mybatis的api， 所以并没有生效*/
    @Override
    public void insertFill(MetaObject metaObject) {
        System.out.println("添加插入时间");
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        System.out.println("添加更新时间");
        this.setFieldValByName("gmtModified",new Date(),metaObject);
    }
}
