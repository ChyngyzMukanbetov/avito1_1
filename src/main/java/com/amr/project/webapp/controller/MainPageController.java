package com.amr.project.webapp.controller;

import com.amr.project.service.abstracts.CategoryService;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final ItemService itemService;
    private final ShopService shopService;
    private final CategoryService categoryService;

    @Autowired
    public MainPageController(ItemService itemService, ShopService shopService, CategoryService categoryService) {
        this.itemService = itemService;
        this.shopService = shopService;
        this.categoryService = categoryService;
    }


    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("items", itemService.getItemList());
        model.addAttribute("shops", shopService.getShopList());
        model.addAttribute("category", categoryService.getCategoryList());
        return "mainPage";
    }
}