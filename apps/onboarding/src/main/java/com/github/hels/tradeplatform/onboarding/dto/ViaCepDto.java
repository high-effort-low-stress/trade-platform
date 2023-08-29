package com.github.hels.tradeplatform.onboarding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViaCepDto {

    @JsonProperty(value = "cep")
    private String zipCode;

    @JsonProperty(value = "logradouro")
    private String StreetName;

    @JsonProperty(value = "bairro")
    private String district;

    @JsonProperty(value = "localidade")
    private String city;

    @JsonProperty(value = "uf")
    private String uf;

}