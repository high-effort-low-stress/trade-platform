package com.github.hels.tradeplatform.onboarding.docs;

import com.github.hels.tradeplatform.onboarding.docs.schemas.InactiveUserSchema;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.*;

@Inherited
@ErrorsDescription
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Inativação de Usuário", method = "DELETE")
@Parameters(value = {
        @Parameter(
                name = "id",
                in =  ParameterIn.PATH, description = "Id do usuário a ser inativado.",
                example = "1001",
                required = true
        )
})

@ApiResponses(value = {
        @ApiResponse(
                responseCode = "200",
                description = "Inativação de usuário.",
                content = @Content(
                        schema = @Schema(implementation = InactiveUserSchema.Response.class),
                        mediaType = MediaType.APPLICATION_JSON_VALUE
                )
        ),
        @ApiResponse(
                responseCode = "204",
                description = "Caso o usuário esteja inativo",
                content = @Content
        )
})

public @interface InactiveUserApi {
}
