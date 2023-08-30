package com.github.hels.tradeplatform.onboarding.docs.schemas.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseSchema {
    @Schema(description = "Token gerado pela aplicação", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJ0cmFkZS1wbGF0Zm9ybSIsInBob25lX251bWJlciI6IjU1OTg5MzIzNzM1MTMiLCJlbWFpbCI6Ikthcmlhbm5lLlByb2hhc2thNUB5YWhvby5jb20iLCJuYW1lIjoiV2lsYmVydCBIdWVscyIsImlhdCI6MTY5MzI2OTQ5NCwiZXhwIjoxNjkzMjczMDk0LCJzdWIiOiJLYXJpYW5uZS5Qcm9oYXNrYTVAeWFob28uY29tIn0.E7xYiO1QJGhfz5LpUrgK08LoDy-623MOk5CobETMi0w", requiredMode = Schema.RequiredMode.REQUIRED)
    private String token;

    @Schema(description = "Tempo de expiração do token", example = "1693437492", requiredMode = Schema.RequiredMode.REQUIRED)
    private Long expiresAt;
}
