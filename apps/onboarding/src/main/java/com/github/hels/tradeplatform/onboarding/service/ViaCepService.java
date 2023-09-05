package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.dto.domain.ViaCepDto;
import com.github.hels.tradeplatform.onboarding.infrastructure.ViaCepClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ViaCepService {
    private final ViaCepClient viaCepClient;

    public ViaCepDto execute(String zipCode) {

        return viaCepClient.viaCep(zipCode);
    }
}
