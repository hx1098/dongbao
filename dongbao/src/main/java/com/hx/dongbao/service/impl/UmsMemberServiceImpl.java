package com.hx.dongbao.service.impl;


import com.hx.dongbao.dto.UmsMemberLoginParamDTO;
import com.hx.dongbao.dto.UmsMemberRegisterParamDTO;
import com.hx.dongbao.dto.UmsMemberUpdateDTO;
import com.hx.dongbao.enums.StateCodeEnum;
import com.hx.dongbao.mapper.UmsMemberMapper;
import com.hx.dongbao.entity.UmsMember;
import com.hx.dongbao.response.UserMemberLoginResponse;
import com.hx.dongbao.service.UmsMemberService;
import com.hx.dongbao.utils.JwtUtil;
import com.hx.dongbao.utils.ResultWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 后台用户表(UmsMember)表服务实现类
 *
 * @author makejava
 * @since 2022-04-24 20:45:48
 */
@Service("umsMemberService")
public class UmsMemberServiceImpl implements UmsMemberService {
    @Resource
    private UmsMemberMapper umsMemberMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UmsMember queryById(Long id) {
        return this.umsMemberMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<UmsMember> queryAllByLimit(int offset, int limit) {
        return this.umsMemberMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param umsMember 实例对象
     * @return 实例对象
     */
    @Override
    public UmsMember insert(UmsMember umsMember) {
        this.umsMemberMapper.insert(umsMember);
        return umsMember;
    }

    /**
     * 修改数据
     *
     * @param umsMember 实例对象
     * @return 实例对象
     */
    @Override
    public UmsMember update(UmsMember umsMember) {
        this.umsMemberMapper.update(umsMember);
        return this.queryById(umsMember.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.umsMemberMapper.deleteById(id) > 0;
    }

    @Override
    public ResultWrapper register(UmsMemberRegisterParamDTO umsMemberREgisterParamDTO) {
        UmsMember umsMember = new UmsMember();
        BeanUtils.copyProperties(umsMemberREgisterParamDTO,umsMember);

        String encode = passwordEncoder.encode(umsMemberREgisterParamDTO.getPassword());

        umsMember.setPassword(encode);

        umsMemberMapper.insert(umsMember);
        return ResultWrapper.getSuccessBuilder().build();

    }

    @Override
    public ResultWrapper login(UmsMemberLoginParamDTO umsMemberLoginParamDTO) {
        //判断是否能进行登录, 能就jia token
        UmsMember umsMember =  umsMemberMapper.selectByName(umsMemberLoginParamDTO.getUsername());
        if (umsMember == null) {
            return ResultWrapper.getFailBuilder().code(StateCodeEnum.USER_EMPTY.getCode()).msg(StateCodeEnum.USER_EMPTY.getMsg()).build();
        } else {
            String passwordDB = umsMember.getPassword();
            if (!passwordEncoder.matches(umsMemberLoginParamDTO.getPassword(), passwordDB)) {
                return ResultWrapper.getFailBuilder().code(StateCodeEnum.PASSWORD_ERROR.getCode()).msg(StateCodeEnum.PASSWORD_ERROR.getMsg()).build();
            }
        }

        String token = JwtUtil.createToken(umsMember.getId() + "");
        UserMemberLoginResponse response = new UserMemberLoginResponse();
        response.setToken(token);
        umsMember.setPassword("");
        response.setUmsMember(umsMember);
        return ResultWrapper.getSuccessBuilder().data(response).build();
    }


    @Override
    public int edit(UmsMemberUpdateDTO umsMemberUpdateDTO) {
        UmsMember umsMember = new UmsMember();
        umsMember.setId(umsMemberUpdateDTO.getId());
        umsMember.setUsername(umsMemberUpdateDTO.getUsername());
        umsMember.setIcon(umsMemberUpdateDTO.getIcon());
        umsMember.setEmail(umsMemberUpdateDTO.getEmail());
        umsMember.setNickName(umsMemberUpdateDTO.getNickName());
        umsMember.setNote(umsMemberUpdateDTO.getNote());
        return umsMemberMapper.update(umsMember);
    }
}
