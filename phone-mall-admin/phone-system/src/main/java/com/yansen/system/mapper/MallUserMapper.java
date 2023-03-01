package com.yansen.system.mapper;

import java.util.List;

import com.yansen.system.domain.MallUser;

/**
 * 客户信息管理Mapper接口
 *
 * @author yansen
 * @date 2023-01-01
 */
public interface MallUserMapper {
    /**
     * 查询客户信息管理
     *
     * @param id 客户信息管理主键
     * @return 客户信息管理
     */
    public MallUser selectMallUserById(Long id);

    /**
     * 查询客户信息管理列表
     *
     * @param mallUser 客户信息管理
     * @return 客户信息管理集合
     */
    public List<MallUser> selectMallUserList(MallUser mallUser);

    /**
     * 新增客户信息管理
     *
     * @param mallUser 客户信息管理
     * @return 结果
     */
    public int insertMallUser(MallUser mallUser);

    /**
     * 修改客户信息管理
     *
     * @param mallUser 客户信息管理
     * @return 结果
     */
    public int updateMallUser(MallUser mallUser);

    /**
     * 删除客户信息管理
     *
     * @param id 客户信息管理主键
     * @return 结果
     */
    public int deleteMallUserById(Long id);

    /**
     * 批量删除客户信息管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMallUserByIds(Long[] ids);
}
