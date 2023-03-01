package com.yansen.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yansen.mall.entity.UserEntity;
import com.yansen.mall.mapper.UserMapper;
import com.yansen.mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService {
    @Autowired
    UserMapper userMapper;

    public void registUser(UserEntity user) {
        this.baseMapper.insert(user);
    }

    public UserEntity login(String username) {
        return userMapper.selectOne(new QueryWrapper<UserEntity>().eq("username",username));
    }

    public boolean existsUsername(String username) {
        if (userMapper.selectOne(new QueryWrapper<UserEntity>().eq("username",username)) != null) {
            return true;
        }
        return false;
    }
}
