package com.yansen.mall.controller;

import com.yansen.mall.entity.CategoryEntity;
import com.yansen.mall.service.CategoryService;
import com.yansen.mall.service.SkuInfoService;
import com.yansen.mall.vo.SkuItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {
    @GetMapping({"/", "/index.html"})
    public String indexPage(Model model) {
        return "index";
    }
}
