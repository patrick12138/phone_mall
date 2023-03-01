package com.yansen.mall.vo;

import com.yansen.mall.entity.OrderEntity;
import com.yansen.mall.entity.OrderItemEntity;
import lombok.Data;

import java.util.List;

@Data
public class OrderListVo {

    private List<OrderItemEntity> orderList;
    /*购物车商品*/
    private List<OrderEntity> orders;
}
