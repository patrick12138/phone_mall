package com.yansen.mall.controller;

import com.yansen.mall.service.SkuInfoService;
import com.yansen.mall.vo.SkuItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SeachController {
    @Autowired
    private SkuInfoService skuInfoService;

    @GetMapping("/search.html")
    public String search(@RequestParam("brandId") Long brandId, Model model) {
        if (brandId == 0) {
            List<SkuItemVo> skuItemVos = skuInfoService.itemVoList();
            model.addAttribute("result", skuItemVos);
        } else {
            List<SkuItemVo> skuItemVoListByBrandId = skuInfoService.itemVoListByBrandId(brandId);
            model.addAttribute("result", skuItemVoListByBrandId);
        }
        return "search";
    }
}
