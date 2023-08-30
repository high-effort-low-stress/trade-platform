package com.github.hels.tradeplatform.onboarding.docs.schemas.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequestSchema {
    @Schema(description = "Email do usuário registrado", example = "email@example.org", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    @Schema(description = "Senha do usuário registrado", example = "p@ssw0rd", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;
}
