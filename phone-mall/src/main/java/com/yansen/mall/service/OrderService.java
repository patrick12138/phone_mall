package com.yansen.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yansen.mall.entity.OrderEntity;

public interface OrderService extends IService<OrderEntity> {
    void deleteOrder(Long orderId);
}
