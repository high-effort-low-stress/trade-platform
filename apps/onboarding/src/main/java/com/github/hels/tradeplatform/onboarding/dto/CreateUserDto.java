package com.github.hels.tradeplatform.onboarding.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
        @NotBlank(message = "a name must be provided.")
        private String name;

        @NotBlank(message = "a CPF must be provided.")
        @CPF(message = "CPF must be valid.")
        private String document;

        @NotBlank(message = "an email must be provided.")
        @Email(message = "Email must be valid.")
        @Pattern(regexp = ".*(\\w+\\.)+\\w+$", message = "Email must be valid.")
        private String email;

        @NotBlank(message = "A password must be provided.")
        private String password;

        @NotBlank(message = "A phone number must be provided.")
        @Pattern(regexp = "\\d{4}9\\d{8}", message = "Phone number must be valid.")
        private String phoneNumber;

        @NotNull(message = "You must provide your birth date.")
        private LocalDate birthDate;

        @NotBlank(message = "Zipcode must not be blank")
        @NotNull(message = "A zipcode must be provided.")
        private String zipCode;

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
