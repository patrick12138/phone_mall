package com.yansen.mall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@ToString
@TableName("mall_order_item")
public class OrderItemEntity {
    @TableId
    private Integer id;
    private Long orderId;
    private Date orderTime;
    private Long skuId;
    private String title;
    private Integer count;
    private String image;
    private BigDecimal totalPrice;
}
