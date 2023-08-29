package com.github.hels.tradeplatform.onboarding.docs.schemas;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;



public class UpdateUserSchema {
    @Getter
    @Setter
    @Schema(name = "UpdateUserRequest")
    public static class Request {
        @Schema(description = "Novo email", example = "email@example.org")
        private String email;

        @Schema(description = "Novo telefone", example = "5521987654321")
        private String phoneNumber;
    }

    @Getter
    @Setter
    @Schema(name = "UpdateUserResponse")
    public static class Response {
        @Schema(description = "Id do usuário atualizado", example = "1001")
        private String id;
    }
}
