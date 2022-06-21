package com.amr.project.converter;


import com.amr.project.model.dto.report.SalesHistoryDto;
import com.amr.project.model.entity.report.SalesHistory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")//, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface SalesHistoryMapper {

    SalesHistoryDto toDTO(SalesHistory salesHistory);

    SalesHistory toModel(SalesHistoryDto salesHistoryDto);

    List<SalesHistory> toModelList(List<SalesHistoryDto> salesHistoryDto);

    List<SalesHistoryDto> toDTOList(List<SalesHistory> salesHistory);
}
