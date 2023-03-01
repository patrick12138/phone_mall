package com.yansen.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yansen.mall.entity.CartItemEntity;
import com.yansen.mall.mapper.CartItemMapper;
import com.yansen.mall.service.CartItemService;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl extends ServiceImpl<CartItemMapper, CartItemEntity> implements CartItemService {
}
