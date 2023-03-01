package com.yansen.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yansen.mall.entity.OrderItemEntity;
import com.yansen.mall.mapper.OrderItemMapper;
import com.yansen.mall.service.CartService;
import com.yansen.mall.service.OrderItemService;
import com.yansen.mall.service.OrderService;
import com.yansen.mall.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements OrderItemService {
    @Autowired
    CartService cartService;
    @Autowired
    OrderService orderService;

    @Override
    public void saveOrderItem() {
        CartVo cart = cartService.getCart();
    }
}
