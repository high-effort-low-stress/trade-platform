package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.dto.domain.AddressDto;
import com.github.hels.tradeplatform.onboarding.dto.domain.ViaCep;
import com.github.hels.tradeplatform.onboarding.mappers.AddressMapper;
import com.github.hels.tradeplatform.onboarding.models.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddressService {

    private final ViaCepService viaCepService;
    private final AddressMapper addressMapper;

    public Address execute(String zipCode, String streetNumber, String complement) {

        ViaCep viaCep = viaCepService.execute(zipCode);

        AddressDto dto = addressMapper.toAddressDto(viaCep);

        dto.setZipCode(formatter(zipCode));
        dto.setComplement(complement);
        dto.setStreetNumber(streetNumber);

        return addressMapper.toAddress(dto);
    }

    private String formatter(String zipCode) {
        return zipCode.replace("-", "");
    }

}
