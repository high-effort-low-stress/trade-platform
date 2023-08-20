package com.github.hels.tradeplatform.ratesimulator.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime datetime;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.datetime = LocalDateTime.now();
    }
}
