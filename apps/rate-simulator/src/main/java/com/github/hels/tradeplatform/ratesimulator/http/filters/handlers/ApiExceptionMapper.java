package com.github.hels.tradeplatform.ratesimulator.http.filters.handlers;

import com.github.hels.tradeplatform.ratesimulator.dtos.ErrorResponse;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.stream.Stream;

@Slf4j
public abstract class ApiExceptionMapper<E extends Throwable> implements ExceptionMapper<E> {

    @Override
    public Response toResponse(E exception){
        log(exception,10);
        return respond(new ErrorResponse(500, "An internal error has ocurred"));
    }

    protected void log(E ex, int stackNumbers) {
        log.error("Message: {}", ex.getMessage());
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<StackTraceElement> elementIterator = Stream.of(ex.getStackTrace()).iterator();
        for (int i = 0; i < stackNumbers && elementIterator.hasNext(); i++)
            stringBuilder.append(elementIterator.next()).append("\n");
        log.info("Error trace: {}", stringBuilder);
    }

    protected Response respond(ErrorResponse response){
        return Response.status(response.getStatus())
                .header("accept", MediaType.APPLICATION_JSON)
                .header("content-type", MediaType.APPLICATION_JSON)
                .encoding(StandardCharsets.UTF_8.name())
                .entity(response)
                .build();
    }
}
