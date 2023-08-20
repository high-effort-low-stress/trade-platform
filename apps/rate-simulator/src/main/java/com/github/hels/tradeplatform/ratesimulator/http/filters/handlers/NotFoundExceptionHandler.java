package com.github.hels.tradeplatform.ratesimulator.http.filters.handlers;


import com.github.hels.tradeplatform.ratesimulator.dtos.ErrorResponse;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Provider
public class NotFoundExceptionHandler extends ApiExceptionMapper<NotFoundException>
{
    @Override
    public Response toResponse(NotFoundException e) {
        log(e,10);
        return respond(new ErrorResponse(404, e.getMessage()));
    }
}
