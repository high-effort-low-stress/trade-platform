package com.github.hels.tradeplatform.onboarding.exceptions.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class StandardError {
    private final String message;
    private final String datetime;

    public StandardError(String message) {
        this.message = message;
        this.datetime = LocalDateTime.now().toString();
    }
}
