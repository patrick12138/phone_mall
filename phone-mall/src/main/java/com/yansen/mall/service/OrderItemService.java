package com.yansen.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yansen.mall.entity.OrderItemEntity;

public interface OrderItemService extends IService<OrderItemEntity> {
    void saveOrderItem();
}
