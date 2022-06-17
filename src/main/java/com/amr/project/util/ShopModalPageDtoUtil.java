package com.amr.project.util;

import com.amr.project.converter.CategoryMapper;
import com.amr.project.converter.ItemMapper;
import com.amr.project.converter.ShopConverter;
import com.amr.project.model.dto.CategoryDto;
import com.amr.project.model.dto.ShopModalPageDto;
import com.amr.project.model.entity.Item;
import com.amr.project.service.abstracts.ItemService;
import com.amr.project.service.abstracts.ShopHistoryService;
import com.amr.project.service.abstracts.ShopService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class ShopModalPageDtoUtil {

    private final ShopConverter shopConverter;
    private final ShopService shopService;
    private final ShopHistoryService shopHistoryService;
    private final ItemMapper itemMapper;
    private final ItemService itemService;
    private final CategoryMapper categoryMapper;

    public ShopModalPageDto getShopModalPageDto(Long shopId) {

        ShopModalPageDto shopModalPageDto = new ShopModalPageDto();
        shopModalPageDto.setShopDto(shopConverter.toDto(shopService.findById(shopId)));
        shopModalPageDto.setShopHistoryList(shopHistoryService.findAllByShop(shopService.findById(shopId)));
        shopModalPageDto.setItemDtoList(itemMapper.toDTOList(itemService.getItemsByShop(shopService.findById(shopId))));
        shopModalPageDto.setItemNameCount(itemService.getItemsByShop(shopService.findById(shopId)).size());

        Integer itemCount = 0;
        for (Item item : itemService.getItemsByShop(shopService.findById(shopId))) {
            itemCount += item.getCount();
        }
        shopModalPageDto.setItemCount(itemCount);

        Set<CategoryDto> categoryDtoList = new HashSet<>();
        for (Item item : itemService.getItemsByShop(shopService.findById(shopId))) {
            categoryDtoList.add(categoryMapper.toDTO(item.getCategory()));
        }
        shopModalPageDto.setCategoryDtoList(categoryDtoList);
        shopModalPageDto.setCategoryCount(categoryDtoList.size());
        shopModalPageDto.setUsername(shopService.findById(shopId).getUser().getUsername());
        return shopModalPageDto;
    }
}
