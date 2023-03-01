package com.yansen.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yansen.product.mapper.MallSkuImagesMapper;
import com.yansen.product.domain.MallSkuImages;
import com.yansen.product.service.IMallSkuImagesService;

/**
 * 商品图片Service业务层处理
 *
 * @author patrick
 * @date 2022-12-31
 */
@Service
public class MallSkuImagesServiceImpl implements IMallSkuImagesService {
    @Autowired
    private MallSkuImagesMapper mallSkuImagesMapper;

    /**
     * 查询商品图片
     *
     * @param id 商品图片主键
     * @return 商品图片
     */
    @Override
    public MallSkuImages selectMallSkuImagesById(Long id) {
        return mallSkuImagesMapper.selectMallSkuImagesById(id);
    }

    /**
     * 查询商品图片列表
     *
     * @param mallSkuImages 商品图片
     * @return 商品图片
     */
    @Override
    public List<MallSkuImages> selectMallSkuImagesList(MallSkuImages mallSkuImages) {
        return mallSkuImagesMapper.selectMallSkuImagesList(mallSkuImages);
    }

    /**
     * 新增商品图片
     *
     * @param mallSkuImages 商品图片
     * @return 结果
     */
    @Override
    public int insertMallSkuImages(MallSkuImages mallSkuImages) {
        return mallSkuImagesMapper.insertMallSkuImages(mallSkuImages);
    }

    /**
     * 修改商品图片
     *
     * @param mallSkuImages 商品图片
     * @return 结果
     */
    @Override
    public int updateMallSkuImages(MallSkuImages mallSkuImages) {
        return mallSkuImagesMapper.updateMallSkuImages(mallSkuImages);
    }

    /**
     * 批量删除商品图片
     *
     * @param ids 需要删除的商品图片主键
     * @return 结果
     */
    @Override
    public int deleteMallSkuImagesByIds(Long[] ids) {
        return mallSkuImagesMapper.deleteMallSkuImagesByIds(ids);
    }

    /**
     * 删除商品图片信息
     *
     * @param id 商品图片主键
     * @return 结果
     */
    @Override
    public int deleteMallSkuImagesById(Long id) {
        return mallSkuImagesMapper.deleteMallSkuImagesById(id);
    }
}
