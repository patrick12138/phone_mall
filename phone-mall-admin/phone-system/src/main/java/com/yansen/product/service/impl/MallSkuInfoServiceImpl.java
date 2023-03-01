package com.yansen.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yansen.product.mapper.MallSkuInfoMapper;
import com.yansen.product.domain.MallSkuInfo;
import com.yansen.product.service.IMallSkuInfoService;

/**
 * 商品信息Service业务层处理
 *
 * @author patrick
 * @date 2022-12-31
 */
@Service
public class MallSkuInfoServiceImpl implements IMallSkuInfoService {
    @Autowired
    private MallSkuInfoMapper mallSkuInfoMapper;

    /**
     * 查询商品信息
     *
     * @param skuId 商品信息主键
     * @return 商品信息
     */
    @Override
    public MallSkuInfo selectMallSkuInfoBySkuId(Long skuId) {
        return mallSkuInfoMapper.selectMallSkuInfoBySkuId(skuId);
    }

    /**
     * 查询商品信息列表
     *
     * @param mallSkuInfo 商品信息
     * @return 商品信息
     */
    @Override
    public List<MallSkuInfo> selectMallSkuInfoList(MallSkuInfo mallSkuInfo) {
        return mallSkuInfoMapper.selectMallSkuInfoList(mallSkuInfo);
    }

    /**
     * 新增商品信息
     *
     * @param mallSkuInfo 商品信息
     * @return 结果
     */
    @Override
    public int insertMallSkuInfo(MallSkuInfo mallSkuInfo) {
        return mallSkuInfoMapper.insertMallSkuInfo(mallSkuInfo);
    }

    /**
     * 修改商品信息
     *
     * @param mallSkuInfo 商品信息
     * @return 结果
     */
    @Override
    public int updateMallSkuInfo(MallSkuInfo mallSkuInfo) {
        return mallSkuInfoMapper.updateMallSkuInfo(mallSkuInfo);
    }

    /**
     * 批量删除商品信息
     *
     * @param skuIds 需要删除的商品信息主键
     * @return 结果
     */
    @Override
    public int deleteMallSkuInfoBySkuIds(Long[] skuIds) {
        return mallSkuInfoMapper.deleteMallSkuInfoBySkuIds(skuIds);
    }

    /**
     * 删除商品信息信息
     *
     * @param skuId 商品信息主键
     * @return 结果
     */
    @Override
    public int deleteMallSkuInfoBySkuId(Long skuId) {
        return mallSkuInfoMapper.deleteMallSkuInfoBySkuId(skuId);
    }
}
