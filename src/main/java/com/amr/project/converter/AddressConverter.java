package com.amr.project.converter;

import com.amr.project.converter.Resolver.AddressResolver;
import com.amr.project.model.dto.AddressDto;
import com.amr.project.model.entity.Address;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        uses = {AddressResolver.class},
        builder = @Builder(disableBuilder = true))
public interface AddressConverter {

    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "city")
    @Mapping(source = "city.country.id", target = "countryId")
    @Mapping(source = "city.country.name", target = "country")
    AddressDto toDto(Address address);


    @Mapping(source = "city.id", target = "cityId")
    @Mapping(source = "city.name", target = "city")
    @Mapping(source = "city.country.id", target = "countryId")
    @Mapping(source = "city.country.name", target = "country")
    List<AddressDto> toDto(List<Address> address);


    @Mapping(target = "city", ignore = true)
    Address toModel(AddressDto addressDto);


    default List<AddressDto> mapModelToList(Address address) {
        if (address != null) {
            List<AddressDto> addressDtoList = new ArrayList<>();
            addressDtoList.add(toDto(address));
            return addressDtoList;
        } else {
            return null;
        }
    }

    default Address mapModelToList(List<AddressDto> dtoList) {
        if (dtoList != null && dtoList.size() > 0) {
            return toModel(dtoList.get(0));
        } else {
            return null;
        }
    }

}
