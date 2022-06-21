package com.amr.project.converter;

import com.amr.project.model.dto.report.SalesHistoryDto;
import com.amr.project.model.entity.report.SalesHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalesHistoryConverter {
    @Mapping(source = "salesHistory.id", target = "id")
    @Mapping(source = "salesHistory.price", target = "price")
    @Mapping(source = "salesHistory.basePrice", target = "basePrice")
    @Mapping(source = "salesHistory.count", target = "count")
    @Mapping(source = "salesHistory.orderDate", target = "orderDate")
    @Mapping(source = "item.name", target = "itemName")
    SalesHistoryDto toDto(SalesHistory salesHistory);


    @Mapping(source = "salesHistory.id", target = "id")
    @Mapping(source = "salesHistory.price", target = "price")
    @Mapping(source = "salesHistory.basePrice", target = "basePrice")
    @Mapping(source = "salesHistory.count", target = "count")
    @Mapping(source = "salesHistory.orderDate", target = "orderDate")
    @Mapping(source = "item.name", target = "itemName")
    List<SalesHistoryDto> toDtoList(List<SalesHistory> salesHistory);
}
