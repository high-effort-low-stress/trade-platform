package com.github.hels.tradeplatform.onboarding.docs;

import com.github.hels.tradeplatform.onboarding.docs.schemas.CreateUserSchema;
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
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Criação de um novo usuário")
@RequestBody(
        description = "Dados a cadastrar",
        content = @Content(
                schema = @Schema(implementation = CreateUserSchema.Request.class),
                mediaType = MediaType.APPLICATION_JSON_VALUE
        )
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Cadastrado com sucesso",
                content = @Content(
                        schema = @Schema(implementation = CreateUserSchema.Response.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        )
})
public @interface CreateUserApi {
}