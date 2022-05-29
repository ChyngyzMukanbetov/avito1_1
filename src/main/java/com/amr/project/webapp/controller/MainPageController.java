package com.amr.project.webapp.controller;

import com.amr.project.service.pages.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final MainPageService mainPageService;

    @Autowired
    public MainPageController(MainPageService mainPageService) {
        this.mainPageService = mainPageService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("items", mainPageService.listItem());
        model.addAttribute("shops", mainPageService.listShop());
        return "mainPage";
    }
}

