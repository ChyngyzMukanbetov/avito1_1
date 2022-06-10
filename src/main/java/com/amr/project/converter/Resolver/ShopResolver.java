package com.amr.project.converter.Resolver;

import com.amr.project.model.dto.ShopDto;
import com.amr.project.model.entity.Shop;
import com.amr.project.service.abstracts.ShopService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ShopResolver {
    private final ShopService shopService;

    @ObjectFactory
    public Shop resolve(ShopDto dto, @TargetType Class<Shop> type) {
        Shop shop;
        if (dto == null) {
            return null;
        } else if (dto.getId() == null) {
            shop = new Shop();
        } else {
            shop = shopService.findById(dto.getId());
        }
        return shop;
    }
}
