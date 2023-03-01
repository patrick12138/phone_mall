package com.yansen.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yansen.mall.entity.SkuImagesEntity;
import com.yansen.mall.entity.SkuInfoEntity;
import com.yansen.mall.mapper.SkuInfoMapper;
import com.yansen.mall.service.SkuImagesService;
import com.yansen.mall.service.SkuInfoService;
import com.yansen.mall.vo.SkuItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfoEntity> implements SkuInfoService {
    @Autowired
    SkuImagesService skuImagesService;

    @Override
    public void saveSkuInfo(SkuInfoEntity skuInfoEntity) {
        this.baseMapper.insert(skuInfoEntity);
    }

    @Override
    public List<SkuInfoEntity> getSkusBySpuId(Long spuId) {
        List<SkuInfoEntity> list = this.list(new QueryWrapper<SkuInfoEntity>().eq("spu_id", spuId));
        return list;
    }

    @Override
    public SkuItemVo item(Long skuId) {
        SkuItemVo skuItemVo = new SkuItemVo();
        SkuInfoEntity info = getById(skuId);
        skuItemVo.setInfo(info);
        List<SkuImagesEntity> imagesEntities = skuImagesService.getImagesBySkuId(skuId);
        skuItemVo.setImagesEntites(imagesEntities);
        return skuItemVo;
    }

    @Override
    public List<SkuItemVo> itemVoList() {
        List<SkuInfoEntity> skuInfoEntityList = list(null);
        List<SkuItemVo> skuItemVoList = skuInfoEntityList.stream().map(skuInfoEntity ->{
            SkuItemVo skuItemVo = new SkuItemVo();
            skuItemVo.setInfo(skuInfoEntity);
            List<SkuImagesEntity> imagesEntities = skuImagesService.getImagesBySkuId(skuInfoEntity.getSkuId());
            skuItemVo.setImagesEntites(imagesEntities);
            return skuItemVo;
        }).collect(Collectors.toList());
        return skuItemVoList;
    }

    @Override
    public List<SkuItemVo> itemVoListByBrandId(Long brandId) {
        List<SkuInfoEntity> brandIdByList = list(new QueryWrapper<SkuInfoEntity>().eq("brand_id", brandId));
        List<SkuItemVo> itemVos = brandIdByList.stream().map(skuInfoEntity ->{
            SkuItemVo skuItemVo = new SkuItemVo();
            skuItemVo.setInfo(skuInfoEntity);
            List<SkuImagesEntity> imagesEntities = skuImagesService.getImagesBySkuId(skuInfoEntity.getSkuId());
            skuItemVo.setImagesEntites(imagesEntities);
            return skuItemVo;
        }).collect(Collectors.toList());
        return itemVos;
    }
}