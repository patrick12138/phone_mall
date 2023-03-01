package com.yansen.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yansen.system.mapper.MallUserMapper;
import com.yansen.system.domain.MallUser;
import com.yansen.system.service.IMallUserService;

/**
 * 客户信息管理Service业务层处理
 *
 * @author yansen
 * @date 2023-01-01
 */
@Service
public class MallUserServiceImpl implements IMallUserService {
    @Autowired
    private MallUserMapper mallUserMapper;

    /**
     * 查询客户信息管理
     *
     * @param id 客户信息管理主键
     * @return 客户信息管理
     */
    @Override
    public MallUser selectMallUserById(Long id) {
        return mallUserMapper.selectMallUserById(id);
    }

    /**
     * 查询客户信息管理列表
     *
     * @param mallUser 客户信息管理
     * @return 客户信息管理
     */
    @Override
    public List<MallUser> selectMallUserList(MallUser mallUser) {
        return mallUserMapper.selectMallUserList(mallUser);
    }

    /**
     * 新增客户信息管理
     *
     * @param mallUser 客户信息管理
     * @return 结果
     */
    @Override
    public int insertMallUser(MallUser mallUser) {
        return mallUserMapper.insertMallUser(mallUser);
    }

    /**
     * 修改客户信息管理
     *
     * @param mallUser 客户信息管理
     * @return 结果
     */
    @Override
    public int updateMallUser(MallUser mallUser) {
        return mallUserMapper.updateMallUser(mallUser);
    }

    /**
     * 批量删除客户信息管理
     *
     * @param ids 需要删除的客户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMallUserByIds(Long[] ids) {
        return mallUserMapper.deleteMallUserByIds(ids);
    }

    /**
     * 删除客户信息管理信息
     *
     * @param id 客户信息管理主键
     * @return 结果
     */
    @Override
    public int deleteMallUserById(Long id) {
        return mallUserMapper.deleteMallUserById(id);
    }
}
