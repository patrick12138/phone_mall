package com.yansen.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yansen.mall.entity.SkuImagesEntity;

import java.util.List;

/**
 * sku图片
 *
 * @author yansen
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    List<SkuImagesEntity> getImagesBySkuId(Long skuId);
}

