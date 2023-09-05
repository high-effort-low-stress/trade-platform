package com.github.hels.tradeplatform.onboarding.infrastructure;

import com.github.hels.tradeplatform.onboarding.dto.domain.ViaCepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "via-cep", url = "${via-cep.url:#{null}}")
public interface ViaCepClient {

    @GetMapping("{zipCode}/json/")
    ViaCepDto viaCep(@PathVariable(value = "zipCode") String zipCode);

}
