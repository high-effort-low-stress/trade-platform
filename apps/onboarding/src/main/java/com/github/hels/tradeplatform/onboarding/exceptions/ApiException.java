package com.github.hels.tradeplatform.onboarding.exceptions;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}