package com.amr.project.webapp.controller.shopController;

import com.amr.project.converter.*;
import com.amr.project.model.dto.*;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/shops")
public class ShopRestController {

    private final ShopService shopService;
    private final CityService cityService;
    private final CountryService countryService;
    private final UserService userService;
    private final ReviewService reviewService;
    private final ShopConverter shopConverter;
    private final CouponService couponService;

    @GetMapping("")
    public List<ShopDto> getAllModeratedShops() {
        List<ShopDto> shopDtoList = new ArrayList<>();
        List<Shop> shopList = shopService.findAll();
        for (Shop shop : shopList) {
            if (shop.isModerated() && shop.isModerateAccept() && !shop.isPretendedToBeDeleted()) {
                shopDtoList.add(shopConverter.toDto(shop));
            }
        }
        return shopDtoList;
    }

    @GetMapping("/foradmin")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    public List<ShopDto> getAllShops() {
        List<ShopDto> shopDtoList = new ArrayList<>();
        List<Shop> shopList = shopService.findAll();
        for (Shop shop : shopList) {
            shopDtoList.add(shopConverter.toDto(shop));
        }
        return shopDtoList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopDto> getShopByIDIfModerated(@PathVariable Long id) {
        Shop shop = shopService.findById(id);
        if (shop.isModerated() && shop.isModerateAccept() && !shop.isPretendedToBeDeleted()) {
            return new ResponseEntity<>(shopConverter.toDto(shop), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/foradmin/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MODERATOR')")
    public ShopDto getShopByID(@PathVariable Long id) {
        return shopConverter.toDto(shopService.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shopDto, Principal principal) {
        if (shopDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            Shop shop = shopConverter.toShop(shopDto);
            shopService.persist(shop);
            return new ResponseEntity<>(shopConverter.toDto(shopService.findById(shop.getId())), HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ShopDto> updateShop(@RequestBody ShopDto shopDto, Principal principal) {
        if (!shopService.existsById(shopDto.getId())) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            // отключено на время тестирования ввиду отсутсвия пока dataBase Auth.
//        } else if ((!shopDto.getUserId().equals(userServiceImpl.findByUsername(principal.getName()).getId())) &&
//                !(userServiceImpl.findByUsername(principal.getName()).getRole()).equals(Roles.ADMIN)) {
//            return new ResponseEntity<ShopDto>(HttpStatus.FORBIDDEN);

        } else {
            Shop shop = shopConverter.toShop(shopDto);
            shop.setModerated(false);
            shop.setModerateAccept(false);
            shop.setPretendedToBeDeleted(false);
            shopService.update(shop);
            return new ResponseEntity<>(shopConverter.toDto(shopService.findById(shopDto.getId())), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ShopDto pretendedToBeDeleted(@PathVariable Long id) {
            shopService.findById(id).setPretendedToBeDeleted(true);
        return shopConverter.toDto(shopService.findById(id));
    }

    @DeleteMapping("/deletemoderated/{id}")
    public ShopDto deleteShop(@RequestParam(value = "isDeleteAccept") boolean isDeleteAccept, @PathVariable Long id) {
        if (isDeleteAccept) {
            shopService.delete(shopService.findById(id));
        }
        return shopConverter.toDto(shopService.findById(id));
    }
}
