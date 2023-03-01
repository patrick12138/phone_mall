package com.yansen.mall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yansen.mall.entity.UserEntity;

public interface UserService extends IService<UserEntity> {
    /**
     * 注册用户
     * @param user
     */
     void registUser(UserEntity user);

    /**
     * 登录
     * @param username
     * @return 如果返回null，说明登录失败，返回有值，是登录成功
     */
     UserEntity login(String username);

    /**
     * 检查 用户名是否可用
     * @param username
     * @return 返回true表示用户名已存在，返回false表示用户名可用
     */
     boolean existsUsername(String username);
}
