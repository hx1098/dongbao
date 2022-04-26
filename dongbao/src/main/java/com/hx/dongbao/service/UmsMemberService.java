package com.hx.dongbao.service;


import com.hx.dongbao.dto.UmsMemberLoginParamDTO;
import com.hx.dongbao.dto.UmsMemberRegisterParamDTO;
import com.hx.dongbao.dto.UmsMemberUpdateDTO;
import com.hx.dongbao.entity.UmsMember;
import com.hx.dongbao.utils.ResultWrapper;

import java.util.List;

/**
 * 后台用户表(UmsMember)表服务接口
 *
 * @author makejava
 * @since 2022-04-24 20:45:47
 */
public interface UmsMemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsMember queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UmsMember> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param umsMember 实例对象
     * @return 实例对象
     */
    UmsMember insert(UmsMember umsMember);

    /**
     * 修改数据
     *
     * @param umsMember 实例对象
     * @return 实例对象
     */
    UmsMember update(UmsMember umsMember);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    ResultWrapper register(UmsMemberRegisterParamDTO umsMemberREgisterParamDTO);

    ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO);

    int edit(UmsMemberUpdateDTO umsMemberUpdateDTO);
}
