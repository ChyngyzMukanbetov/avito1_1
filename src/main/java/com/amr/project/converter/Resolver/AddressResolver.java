package com.amr.project.converter.Resolver;

import com.amr.project.model.dto.AddressDto;
import com.amr.project.model.entity.Address;
import com.amr.project.service.abstracts.AddressService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.mapstruct.TargetType;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressResolver {
    private final AddressService addressService;

    @ObjectFactory
    public Address resolve(AddressDto dto, @TargetType Class<Address> type) {
        if (dto == null) {
            return null;
        } else {
            return addressService.findById(dto.getId());
        }
    }

}
