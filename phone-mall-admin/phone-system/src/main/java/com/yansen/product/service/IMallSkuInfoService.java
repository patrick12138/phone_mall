package com.yansen.product.service;

import java.util.List;

import com.yansen.product.domain.MallSkuInfo;

/**
 * 商品信息Service接口
 *
 * @author patrick
 * @date 2022-12-31
 */
public interface IMallSkuInfoService {
    /**
     * 查询商品信息
     *
     * @param skuId 商品信息主键
     * @return 商品信息
     */
    public MallSkuInfo selectMallSkuInfoBySkuId(Long skuId);

    /**
     * 查询商品信息列表
     *
     * @param mallSkuInfo 商品信息
     * @return 商品信息集合
     */
    public List<MallSkuInfo> selectMallSkuInfoList(MallSkuInfo mallSkuInfo);

    /**
     * 新增商品信息
     *
     * @param mallSkuInfo 商品信息
     * @return 结果
     */
    public int insertMallSkuInfo(MallSkuInfo mallSkuInfo);

    /**
     * 修改商品信息
     *
     * @param mallSkuInfo 商品信息
     * @return 结果
     */
    public int updateMallSkuInfo(MallSkuInfo mallSkuInfo);

    /**
     * 批量删除商品信息
     *
     * @param skuIds 需要删除的商品信息主键集合
     * @return 结果
     */
    public int deleteMallSkuInfoBySkuIds(Long[] skuIds);

    /**
     * 删除商品信息信息
     *
     * @param skuId 商品信息主键
     * @return 结果
     */
    public int deleteMallSkuInfoBySkuId(Long skuId);
}
