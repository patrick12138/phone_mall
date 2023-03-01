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
import com.yansen.product.domain.MallSkuInfo;
import com.yansen.product.service.IMallSkuInfoService;
import com.yansen.common.utils.poi.ExcelUtil;
import com.yansen.common.core.page.TableDataInfo;

/**
 * 商品信息Controller
 *
 * @author patrick
 * @date 2022-12-31
 */
@RestController
@RequestMapping("/product/info")
public class MallSkuInfoController extends BaseController {
    @Autowired
    private IMallSkuInfoService mallSkuInfoService;

    /**
     * 查询商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('product:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallSkuInfo mallSkuInfo) {
        startPage();
        List<MallSkuInfo> list = mallSkuInfoService.selectMallSkuInfoList(mallSkuInfo);
        return getDataTable(list);
    }

    /**
     * 导出商品信息列表
     */
    @PreAuthorize("@ss.hasPermi('product:info:export')")
    @Log(title = "商品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MallSkuInfo mallSkuInfo) {
        List<MallSkuInfo> list = mallSkuInfoService.selectMallSkuInfoList(mallSkuInfo);
        ExcelUtil<MallSkuInfo> util = new ExcelUtil<MallSkuInfo>(MallSkuInfo.class);
        util.exportExcel(response, list, "商品信息数据");
    }

    /**
     * 获取商品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('product:info:query')")
    @GetMapping(value = "/{skuId}")
    public AjaxResult getInfo(@PathVariable("skuId") Long skuId) {
        return success(mallSkuInfoService.selectMallSkuInfoBySkuId(skuId));
    }

    /**
     * 新增商品信息
     */
    @PreAuthorize("@ss.hasPermi('product:info:add')")
    @Log(title = "商品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallSkuInfo mallSkuInfo) {
        return toAjax(mallSkuInfoService.insertMallSkuInfo(mallSkuInfo));
    }

    /**
     * 修改商品信息
     */
    @PreAuthorize("@ss.hasPermi('product:info:edit')")
    @Log(title = "商品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallSkuInfo mallSkuInfo) {
        return toAjax(mallSkuInfoService.updateMallSkuInfo(mallSkuInfo));
    }

    /**
     * 删除商品信息
     */
    @PreAuthorize("@ss.hasPermi('product:info:remove')")
    @Log(title = "商品信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{skuIds}")
    public AjaxResult remove(@PathVariable Long[] skuIds) {
        return toAjax(mallSkuInfoService.deleteMallSkuInfoBySkuIds(skuIds));
    }
}
