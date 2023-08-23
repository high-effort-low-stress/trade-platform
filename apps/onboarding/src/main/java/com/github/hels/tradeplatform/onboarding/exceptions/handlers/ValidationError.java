package com.github.hels.tradeplatform.onboarding.exceptions.handlers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ValidationError {
    private final List<Error> errors;
    private final String datetime;

    public ValidationError() {
        errors = new ArrayList<>();
        datetime = LocalDateTime.now().toString();
    }

    public ValidationError(String field, String message) {
        this();
        addError(field, message);
    }

    public void addError(String field, String message) {
        errors.add(new Error(field, message));
    }

    @Getter
    @AllArgsConstructor
    public static class Error {
        private String field;
        private String message;
    }
}