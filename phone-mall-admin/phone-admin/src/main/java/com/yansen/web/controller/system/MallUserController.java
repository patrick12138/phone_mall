package com.yansen.web.controller.system;

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
import com.yansen.system.domain.MallUser;
import com.yansen.system.service.IMallUserService;
import com.yansen.common.utils.poi.ExcelUtil;
import com.yansen.common.core.page.TableDataInfo;

/**
 * 客户信息管理Controller
 *
 * @author yansen
 * @date 2023-01-01
 */
@RestController
@RequestMapping("/system/mall_user")
public class MallUserController extends BaseController {
    @Autowired
    private IMallUserService mallUserService;

    /**
     * 查询客户信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:mall_user:list')")
    @GetMapping("/list")
    public TableDataInfo list(MallUser mallUser) {
        startPage();
        List<MallUser> list = mallUserService.selectMallUserList(mallUser);
        return getDataTable(list);
    }

    /**
     * 导出客户信息管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:mall_user:export')")
    @Log(title = "客户信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MallUser mallUser) {
        List<MallUser> list = mallUserService.selectMallUserList(mallUser);
        ExcelUtil<MallUser> util = new ExcelUtil<MallUser>(MallUser.class);
        util.exportExcel(response, list, "客户信息管理数据");
    }

    /**
     * 获取客户信息管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:mall_user:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(mallUserService.selectMallUserById(id));
    }

    /**
     * 新增客户信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:mall_user:add')")
    @Log(title = "客户信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MallUser mallUser) {
        return toAjax(mallUserService.insertMallUser(mallUser));
    }

    /**
     * 修改客户信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:mall_user:edit')")
    @Log(title = "客户信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MallUser mallUser) {
        return toAjax(mallUserService.updateMallUser(mallUser));
    }

    /**
     * 删除客户信息管理
     */
    @PreAuthorize("@ss.hasPermi('system:mall_user:remove')")
    @Log(title = "客户信息管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(mallUserService.deleteMallUserByIds(ids));
    }
}
