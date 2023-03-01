package com.yansen.mall.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.yansen.mall.entity.CategoryEntity;

import java.util.List;

/**
 * 商品三级分类
 */
public interface CategoryService extends IService<CategoryEntity> {

    List<CategoryEntity> listWithTree();

    void removeMenuByIds(List<Long> asList);

    void updateCascade(CategoryEntity category);

    List<CategoryEntity> getLevel1Categorys();
}

