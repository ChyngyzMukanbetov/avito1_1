package com.amr.project.webapp.controller.shopController;

import com.amr.project.converter.ShopConverter;
import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/shops")
public class ShopViewController {

    private final ShopService shopService;

    private final ShopConverter shopConverter;

    @GetMapping("/{id}")
    public String getShopByID(Model model, @PathVariable Long id) {
        if (shopService.existsById(id)) {
            Shop shop = shopService.findById(id);
            if (shop.isModerated() && shop.isModerateAccept() && !shop.isPretendedToBeDeleted()) {
                model.addAttribute("shopDto", shopConverter.toDto(shop));
                return "showcase";
            } else return "notFound";
        } else return "notFound";
    }

    @GetMapping("/items/{id}")
    public String getItemsShopByID(Model model, @PathVariable Long id) {
        if (shopService.existsById(id)) {
            Shop shop = shopService.findById(id);
            if (shop.isModerated() && shop.isModerateAccept() && !shop.isPretendedToBeDeleted()) {
                model.addAttribute("shopDto", shopConverter.toDto(shop));
                return "showcaseAllProducts";
            } else return "notFound";
        } else return "notFound";
    }

    @GetMapping("")
    public String getAllShops(Model model) {
        List<Shop> shopList = shopService.findAll();
        List<ShopDto> shopDtoList = new ArrayList<>();
        for (Shop shop : shopList) {
            if (shop.isModerated() && shop.isModerateAccept() && !shop.isPretendedToBeDeleted()) {
                shopDtoList.add(shopConverter.toDto(shop));
            }
        }
        model.addAttribute("shopDtoList", shopDtoList);
        return "allShopsView";
    }
}
