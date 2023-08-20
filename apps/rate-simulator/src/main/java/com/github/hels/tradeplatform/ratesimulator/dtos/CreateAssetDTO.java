package com.github.hels.tradeplatform.ratesimulator.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

public class CreateAssetDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Request{
        @NotBlank
        private String assetType;
        @NotBlank
        private String ticket;
        @NotNull
        private BigDecimal initialValue;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class Response{
        @NotBlank
        private Long id;
    }
}
