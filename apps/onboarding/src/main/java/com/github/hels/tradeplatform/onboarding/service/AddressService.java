package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.dto.domain.AddressDto;
import com.github.hels.tradeplatform.onboarding.infrastructure.ViaCep;
import com.github.hels.tradeplatform.onboarding.mappers.AddressMapper;
import com.github.hels.tradeplatform.onboarding.models.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class AddressService {

    private final ViaCepService viaCepService;
    private final AddressMapper addressMapper;

    public Address execute(
            AddressDto dto
    ) {
        if (
                !dto.getZipCode().isEmpty() &&
                !dto.getCity().isEmpty() &&
                !dto.getUf().isEmpty() &&
                !dto.getDistrict().isEmpty() &&
                !dto.getStreetName().isEmpty()
        ) {
            ViaCep viaCep = viaCepService.execute(dto.getZipCode());

            if (Objects.isNull(dto.getUf()) || dto.getUf().isEmpty())
                dto.setUf(viaCep.getUf());

            if (Objects.isNull(dto.getCity()) || dto.getCity().isEmpty())
                dto.setCity(viaCep.getCity());

            if (Objects.isNull(dto.getStreetName()) || dto.getStreetName().isEmpty())
                dto.setStreetName(viaCep.getStreetName());

            if (Objects.isNull(dto.getDistrict()) || dto.getDistrict().isEmpty())
                dto.setDistrict(viaCep.getDistrict());
        }
        return addressMapper.toAddress(dto);
    }

    private String formatter(String zipCode) {
        return zipCode.replace("-", "");
    }
}


