package com.yansen.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yansen.mall.entity.SkuInfoEntity;
import com.yansen.mall.vo.SkuItemVo;

import java.util.List;

/**
 * sku信息
 *
 * @author yansen
 */
public interface SkuInfoService extends IService<SkuInfoEntity> {

    void saveSkuInfo(SkuInfoEntity skuInfoEntity);

    List<SkuInfoEntity> getSkusBySpuId(Long spuId);

    SkuItemVo item(Long skuId);

    List<SkuItemVo> itemVoList();

    List<SkuItemVo> itemVoListByBrandId(Long brandId);
}

