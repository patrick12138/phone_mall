package com.yansen.mall.vo;

import com.yansen.mall.entity.CartItemEntity;

import java.math.BigDecimal;
import java.util.List;

public class CartVo {
    private List<CartItemEntity> Items;
    private Integer countNum;
    private Integer countType;
    private BigDecimal totalAmount;
    private BigDecimal reduce = new BigDecimal(0);

    public List<CartItemEntity> getItems() {
        return Items;
    }

    public void setItems(List<CartItemEntity> items) {
        this.Items = items;
    }

    public Integer getCountNum() {
        int count = 0;
        if (Items != null && Items.size() > 0) {
            for (CartItemEntity item : Items) {
                count += item.getCount();
            }
        }
        return count;
    }

    public Integer getCountType() {
        int count = 0;
        if (Items != null && Items.size() > 0) {
            for (CartItemEntity item : Items) {
                count += 1;
            }
        }
        return countType;
    }

    public BigDecimal getTotalAmount() {
        BigDecimal amount = new BigDecimal(0);
        //1.计算购物车所有商品总价
        if (Items != null && Items.size() > 0) {
            for (CartItemEntity item : Items) {
                BigDecimal totalPrice = item.getTotalPrice();
                amount = amount.add(totalPrice);
            }
        }
        //2.减去优惠价格
        BigDecimal amountFinal = amount.subtract(getReduce());
        return amountFinal;
    }

    public BigDecimal getReduce() {
        return reduce;
    }

    public void setReduce(BigDecimal reduce) {
        this.reduce = reduce;
    }
}
