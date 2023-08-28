package com.github.hels.tradeplatform.onboarding.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class LoginDto {

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request{

        @NotBlank(message = "an email must be provided.")
        @Email(message = "Email must be valid.")
        @Pattern(regexp = ".*(\\w+\\.)+\\w+$", message = "Email must be valid.")
        private String email;

        @NotBlank(message = "A password must be provided.")
        private String password;
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response{
        private String token;
        private Integer expiresIn = 3600;
    }

}
