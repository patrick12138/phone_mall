package com.yansen.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;


@Data
@TableName("mall_order")
public class OrderEntity {
    @TableId(value = "order_id",type = IdType.ASSIGN_ID)
    private Long orderId;
    private BigDecimal total;
    private String paymentWay;
    private String deliverWay;
    private Date orderTime;
    private String orderState;
}
