package com.github.hels.tradeplatform.onboarding.infrastructure;

import com.github.hels.tradeplatform.onboarding.dto.ViaCepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "viaCep", url = "https://viacep.com.br/ws/")
public interface IViaCep {

    @GetMapping("{zipCode}/json/")
    ViaCepDto viaCep(@PathVariable(value = "zipCode") String zipCode);

}
