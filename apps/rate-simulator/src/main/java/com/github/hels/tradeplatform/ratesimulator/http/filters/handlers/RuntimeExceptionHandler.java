package com.github.hels.tradeplatform.ratesimulator.http.filters.handlers;


import com.github.hels.tradeplatform.ratesimulator.dtos.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class RuntimeExceptionHandler extends ApiExceptionMapper<RuntimeException>
{
    @Override
    public Response toResponse(RuntimeException e) {
        log(e,10);
        return respond(new ErrorResponse(400, e.getMessage()));
    }
}
