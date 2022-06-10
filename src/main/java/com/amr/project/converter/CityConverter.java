package com.amr.project.converter;

import com.amr.project.converter.Resolver.CityResolver;
import com.amr.project.model.dto.CityDto;
import com.amr.project.model.entity.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CityResolver.class)
public interface CityConverter {

    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "countryName")
    CityDto toDto(City city);

    @Mapping(target = "country", ignore = true)
    @Mapping(target = "name", ignore = true)
    City toCity(CityDto cityDto);
}
