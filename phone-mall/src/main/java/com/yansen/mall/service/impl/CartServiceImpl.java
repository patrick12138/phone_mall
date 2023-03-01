package com.yansen.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yansen.mall.entity.SkuInfoEntity;
import com.yansen.mall.service.CartItemService;
import com.yansen.mall.service.CartService;
import com.yansen.mall.service.SkuInfoService;
import com.yansen.mall.vo.CartVo;
import com.yansen.mall.entity.CartItemEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@Slf4j
public class CartServiceImpl implements CartService {
    @Autowired
    SkuInfoService skuInfoService;

    @Autowired
    CartItemService cartItemService;

    @Override
    public CartItemEntity addToCart(Long skuId, Integer num) {
        CartItemEntity cartItem = new CartItemEntity();
        SkuInfoEntity data = skuInfoService.getById(skuId);
        if (cartItemService.getById(skuId) != null) {
            Integer newNum = cartItemService.getById(skuId).getCount() + num;
            countItem(skuId, newNum);
            return null;
        }
        cartItem.setSkuId(skuId);
        cartItem.setCheck(0);
        cartItem.setTitle(data.getSkuTitle());
        cartItem.setImage(data.getSkuDefaultImg());
        cartItem.setSkuAttr("手机");
        cartItem.setPrice(data.getPrice());
        cartItem.setCount(num);
        cartItemService.save(cartItem);
        return cartItem;
    }

    @Override
    public CartItemEntity getCartItem(Long skuId) {
        return cartItemService.getById(skuId);
    }

    @Override
    public void clearCart() {
        cartItemService.remove(new QueryWrapper<>());
    }

    @Override
    public CartVo getCart() {
        CartVo cart = new CartVo();
        List<CartItemEntity> list = cartItemService.list(null);
        cart.setItems(list);
        return cart;
    }

    @Override
    public void checkItem(Long skuId, Integer check) {
        CartItemEntity cartItem = getCartItem(skuId);
        cartItem.setCheck(check);
        cartItemService.update(cartItem, new QueryWrapper<CartItemEntity>().eq("sku_id", skuId));
    }

    @Override
    public void countItem(Long skuId, Integer num) {
        CartItemEntity cartItem = getCartItem(skuId);
        cartItem.setCount(num);
        cartItemService.update(cartItem, new QueryWrapper<CartItemEntity>().eq("sku_id", skuId));
    }

    @Override
    public void deleteItem(Long skuId) {
        cartItemService.remove(new QueryWrapper<CartItemEntity>().eq("sku_id", skuId));
    }
}
