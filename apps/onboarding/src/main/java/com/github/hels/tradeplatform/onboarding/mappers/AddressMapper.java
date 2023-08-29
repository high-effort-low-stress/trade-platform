package com.github.hels.tradeplatform.onboarding.mappers;

import com.github.hels.tradeplatform.onboarding.dto.ViaCepDto;
import com.github.hels.tradeplatform.onboarding.models.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address toAddress(ViaCepDto dto) {
        if (dto == null)
            return null;
        Address address = new Address();
        address.setZipcode(dto.getZipCode());
        address.setStreetName(dto.getStreetName());
        address.setDistrict(dto.getDistrict());
        address.setUf(dto.getUf());
        return address;
    }

    public ViaCepDto toDto(Address entity) {
        if (entity == null)
            return null;
        ViaCepDto dto = new ViaCepDto();
        dto.setZipCode(entity.getZipcode());
        dto.setStreetName(entity.getStreetName());
        dto.setDistrict(entity.getDistrict());
        dto.setUf(entity.getUf());
        return dto;
    }

}
