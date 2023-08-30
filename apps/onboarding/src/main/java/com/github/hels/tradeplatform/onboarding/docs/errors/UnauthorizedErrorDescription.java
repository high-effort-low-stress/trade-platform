package com.github.hels.tradeplatform.onboarding.docs.errors;

import com.github.hels.tradeplatform.onboarding.exceptions.responses.StandardError;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.*;

@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@ApiResponses(value = {
        @ApiResponse(
                responseCode = "401",
                description = "Não Autorizado",
                content = @Content(
                        mediaType = MediaType.APPLICATION_JSON_VALUE,
                        schema = @Schema(implementation = StandardError.class)
                )
        )
})
public @interface UnauthorizedErrorDescription {
}
