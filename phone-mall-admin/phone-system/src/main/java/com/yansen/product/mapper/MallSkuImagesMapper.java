package com.yansen.product.mapper;

import java.util.List;

import com.yansen.product.domain.MallSkuImages;

/**
 * 商品图片Mapper接口
 *
 * @author patrick
 * @date 2022-12-31
 */
public interface MallSkuImagesMapper {
    /**
     * 查询商品图片
     *
     * @param id 商品图片主键
     * @return 商品图片
     */
    public MallSkuImages selectMallSkuImagesById(Long id);

    /**
     * 查询商品图片列表
     *
     * @param mallSkuImages 商品图片
     * @return 商品图片集合
     */
    public List<MallSkuImages> selectMallSkuImagesList(MallSkuImages mallSkuImages);

    /**
     * 新增商品图片
     *
     * @param mallSkuImages 商品图片
     * @return 结果
     */
    public int insertMallSkuImages(MallSkuImages mallSkuImages);

    /**
     * 修改商品图片
     *
     * @param mallSkuImages 商品图片
     * @return 结果
     */
    public int updateMallSkuImages(MallSkuImages mallSkuImages);

    /**
     * 删除商品图片
     *
     * @param id 商品图片主键
     * @return 结果
     */
    public int deleteMallSkuImagesById(Long id);

    /**
     * 批量删除商品图片
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMallSkuImagesByIds(Long[] ids);
}
