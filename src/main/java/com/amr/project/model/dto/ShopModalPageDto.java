package com.amr.project.model.dto;

import com.amr.project.model.entity.report.ShopHistory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ShopModalPageDto {
    private ShopDto shopDto;
    private List<ShopHistory> shopHistoryList;
    private List<ItemDto> itemDtoList;
    private Integer itemNameCount;     //количество наименований товара
    private Integer itemCount;         //количество единиц товара в наличии (item.count)
    private Set<CategoryDto> categoryDtoList;
    private Integer categoryCount;     //количество категорий товара
    private String username;
}
