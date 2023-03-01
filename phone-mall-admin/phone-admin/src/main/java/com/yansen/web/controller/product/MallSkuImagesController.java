package com.yansen.web.controller.product;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yansen.common.annotation.Log;
import com.yansen.common.core.controller.BaseController;
import com.yansen.common.core.domain.AjaxResult;
import com.yansen.common.enums.BusinessType;
import com.yansen.product.domain.MallSkuImages;
import com.yansen.product.service.IMallSkuImagesService;
import com.yansen.common.utils.poi.ExcelUtil;
import com.yansen.common.core.page.TableDataInfo;

/**
 * 商品图片Controller
 *
 * @author patrick
 * @date 2022-12-31
 */
@RestController
@RequestMapping("/product/images")
public class MallSkuImagesController extends BaseController {
    @Autowired
    private IMallSkuImagesService mallSkuImagesService;

    /**
     * 查询商品图片列表
     */
    @PreAuthorize("@ss.hasPermi('product:images:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallSkuImages mallSkuImages) {
        startPage();
        List<MallSkuImages> list = mallSkuImagesService.selectMallSkuImagesList(mallSkuImages);
        return getDataTable(list);
    }

    /**
     * 导出商品图片列表
     */
    @PreAuthorize("@ss.hasPermi('product:images:export')")
    @Log(title = "商品图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MallSkuImages mallSkuImages) {
        List<MallSkuImages> list = mallSkuImagesService.selectMallSkuImagesList(mallSkuImages);
        ExcelUtil<MallSkuImages> util = new ExcelUtil<MallSkuImages>(MallSkuImages.class);
        util.exportExcel(response, list, "商品图片数据");
    }

    /**
     * 获取商品图片详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:images:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(mallSkuImagesService.selectMallSkuImagesById(id));
    }

    /**
     * 新增商品图片
     */
    @PreAuthorize("@ss.hasPermi('product:images:add')")
    @Log(title = "商品图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallSkuImages mallSkuImages) {
        return toAjax(mallSkuImagesService.insertMallSkuImages(mallSkuImages));
    }

    /**
     * 修改商品图片
     */
    @PreAuthorize("@ss.hasPermi('product:images:edit')")
    @Log(title = "商品图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallSkuImages mallSkuImages) {
        return toAjax(mallSkuImagesService.updateMallSkuImages(mallSkuImages));
    }

    /**
     * 删除商品图片
     */
    @PreAuthorize("@ss.hasPermi('product:images:remove')")
    @Log(title = "商品图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mallSkuImagesService.deleteMallSkuImagesByIds(ids));
    }
}
