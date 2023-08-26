package com.github.hels.tradeplatform.onboarding.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
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
        @NotNull(message = "an email must be provided.")
        @Email(message = "Email must be valid.")
        @Pattern(regexp = ".*(\\w+\\.)+\\w+$", message = "Email must be valid.")
        private String email;

        @NotNull(message = "A phone number must be provided.")
        @Pattern(regexp = "\\d{4}9\\d{8}", message = "Phone number must be valid.")
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
