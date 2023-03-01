package com.yansen.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yansen.mall.entity.OrderEntity;
import com.yansen.mall.mapper.OrderMapper;
import com.yansen.mall.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements OrderService {

    @Override
    public void deleteOrder(Long orderId) {
        this.baseMapper.delete(new QueryWrapper<OrderEntity>().eq("order_id",orderId));
    }
}
