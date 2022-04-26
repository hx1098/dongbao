package com.hx.dongbao.mapper;


import com.hx.dongbao.entity.UmsMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户表(UmsMember)表数据库访问层
 *
 * @author makejava
 * @since 2022-04-24 20:45:46
 */
@Mapper
public interface UmsMemberMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UmsMember queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<UmsMember> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param umsMember 实例对象
     * @return 对象列表
     */
    List<UmsMember> queryAll(UmsMember umsMember);

    /**
     * 新增数据
     *
     * @param umsMember 实例对象
     * @return 影响行数
     */
    int insert(UmsMember umsMember);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsMember> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UmsMember> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UmsMember> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<UmsMember> entities);

    /**
     * 修改数据
     *
     * @param umsMember 实例对象
     * @return 影响行数
     */
    int update(UmsMember umsMember);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    UmsMember selectByName(String username);

}

