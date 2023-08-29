package com.github.hels.tradeplatform.onboarding.dto;

import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserDto {
    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        @Pattern(regexp = ".*(\\w+\\.)+\\w+$", message = "Email must be valid.")
        private String email;

        @Pattern(regexp = "55\\d{4}9\\d{8}", message = "Phone number must be valid.")
        private String phoneNumber;

    }
    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private Long id;
    }
}