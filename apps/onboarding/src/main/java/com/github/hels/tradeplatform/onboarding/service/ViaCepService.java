package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.dto.ViaCepDto;
import com.github.hels.tradeplatform.onboarding.infrastructure.IViaCep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViaCepService {
    private final IViaCep address;

    public ViaCepDto execute(String zipCode) {

        return address.viaCep(zipCode);
    }
}
