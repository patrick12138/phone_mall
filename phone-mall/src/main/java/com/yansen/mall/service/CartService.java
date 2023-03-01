package com.yansen.mall.service;


import com.yansen.mall.vo.CartVo;
import com.yansen.mall.entity.CartItemEntity;

import java.util.concurrent.ExecutionException;

public interface CartService {
    //将商品添加到购物车
    CartItemEntity addToCart(Long skuId, Integer num) throws ExecutionException, InterruptedException;

    //查询购物车的某个购物项
    CartItemEntity getCartItem(Long skuId);

    //清空购物车
    void clearCart();

    //获取购物车所有商品
    CartVo getCart();

    //勾选购物项
    void checkItem(Long skuId, Integer check);

    //修改购物项数量
    void countItem(Long skuId, Integer num);

    //删除购物项
    void deleteItem(Long skuId);
}
