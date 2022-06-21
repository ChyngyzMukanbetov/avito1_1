package com.amr.project.webapp.controller;

import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.CategoryService;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.MainPageService;
import com.amr.project.service.abstracts.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final ItemService itemService;
    private final ShopService shopService;
    private final CategoryService categoryService;

    private final MainPageService mainPageService;

    @Autowired
    public MainPageController(ItemService itemService, ShopService shopService, CategoryService categoryService, MainPageService mainPageService) {
        this.itemService = itemService;
        this.shopService = shopService;
        this.categoryService = categoryService;
        this.mainPageService = mainPageService;
    }


    @GetMapping("/")
    public String getAll( Model model) {
        model.addAttribute ("mainPageDto", mainPageService.getMainPageDto());
        return "/mainPage/mainPage";
    }

    @GetMapping("/items")
    public String getItems(@PageableDefault(size =3) Pageable pageable,
                           Model model) {
        Page<Item > page = itemService.getAll(pageable);
        model.addAttribute("page", page);
        return "/mainPage/items_page";
    }


}
