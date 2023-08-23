package com.github.hels.tradeplatform.onboarding.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDto {

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        @NotNull
        private String name;
        @CPF(message = "CPF must be valid.")
        private String document;
        @Email(message = "Email must be valid.")
        private String email;
        private String password;
        private String phoneNumber;
        private LocalDate birthDate;

    }

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private String id;
    }
}
