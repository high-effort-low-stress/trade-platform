package com.github.hels.tradeplatform.onboarding.docs;

import com.github.hels.tradeplatform.onboarding.docs.schemas.UpdateUserSchema;
import com.github.hels.tradeplatform.onboarding.docs.errors.ErrorsDescription;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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
@Operation(
        summary = "Atualização de dados cadastrais: email e/ ou telefone",
        method = "PATCH"
)

@Parameters(value = {
    @Parameter(
            name = "id",
            in =  ParameterIn.PATH, description = "Id do usuário a ser atualizado.",
            example = "1001",
            required = true
    )
})

@RequestBody(
        description = "Dados a serem atualizados",
        content = @Content(
                schema = @Schema(implementation = UpdateUserSchema.Request.class),
                mediaType = MediaType.APPLICATION_JSON_VALUE
        )
)
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Atualização bem sucedida",
                content = @Content(
                        schema = @Schema(implementation = UpdateUserSchema.Response.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        )
})
public @interface UpdateUserApi {
}
