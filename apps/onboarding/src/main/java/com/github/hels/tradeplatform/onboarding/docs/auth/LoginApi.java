package com.github.hels.tradeplatform.onboarding.docs.auth;

import com.github.hels.tradeplatform.onboarding.docs.errors.ErrorsDescription;
import com.github.hels.tradeplatform.onboarding.docs.errors.UnauthorizedErrorDescription;
import com.github.hels.tradeplatform.onboarding.docs.schemas.auth.LoginRequestSchema;
import com.github.hels.tradeplatform.onboarding.docs.schemas.auth.LoginResponseSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.*;

@Inherited
@ErrorsDescription
@UnauthorizedErrorDescription
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Autenticação de um usuário")
@RequestBody(
        description = "Credenciais do usuário",
        content = @Content(
                schema = @Schema(implementation = LoginRequestSchema.class),
                mediaType = MediaType.APPLICATION_JSON_VALUE
        )
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Autenticado com sucesso",
                content = @Content(
                                schema = @Schema(implementation = LoginResponseSchema.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        )
})
public @interface LoginApi {
}
