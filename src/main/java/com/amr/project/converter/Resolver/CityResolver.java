package com.amr.project.converter.Resolver;

import com.amr.project.model.dto.CityDto;
import com.amr.project.model.entity.City;
import com.amr.project.service.abstracts.CityService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CityResolver {
    private final CityService cityService;

    @ObjectFactory
    public City resolve(CityDto dto, @TargetType Class<City> type) {
        if (dto == null) {
            return null;
        } else {
            return cityService.findById(dto.getId());
        }
    }
}
