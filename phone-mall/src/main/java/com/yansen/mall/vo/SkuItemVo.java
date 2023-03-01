package com.yansen.mall.vo;


import com.yansen.mall.entity.SkuImagesEntity;
import com.yansen.mall.entity.SkuInfoEntity;
import lombok.Data;

import java.util.List;

@Data
public class SkuItemVo {
    //1.sku基本信息获取
    SkuInfoEntity info;

    //2.sku图片信息
    List<SkuImagesEntity> imagesEntites;
}
