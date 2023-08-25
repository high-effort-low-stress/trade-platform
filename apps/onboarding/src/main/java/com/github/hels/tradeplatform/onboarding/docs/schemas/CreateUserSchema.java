package com.github.hels.tradeplatform.onboarding.docs.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


public class CreateUserSchema {
    @Getter
    @Setter
    @Schema(name = "CreateUserRequest")
    public static class Request {
        @Schema(description = "Nome do usuário registrado", example = "João de Souza", required = true)
        private String name;

        @Schema(description = "CPF do usuário registrado", example = "52860949020", required = true)
        private String document;

        @Schema(description = "Email do usuário registrado", example = "email@example.org", required = true)
        private String email;

        @Schema(description = "Senha do usuário registrado", example = "p@ssw0rd", required = true)
        private String password;

        @Schema(description = "Telefone do usuário registrado", example = "5521987654321", required = true)
        private String phoneNumber;

        @Schema(description = "Data de aniversário do usuário registrado", example = "2000-01-01",  required = true)
        private LocalDate birthDate;
    }

    @Getter
    @Setter
    @Schema(name = "CreateUserResponse")
    public static class Response {
        @Schema(description = "Id do usuário registrado", example = "1001")
        private String id;
    }

}
