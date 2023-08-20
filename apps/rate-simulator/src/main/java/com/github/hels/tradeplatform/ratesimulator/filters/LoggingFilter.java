package com.github.hels.tradeplatform.ratesimulator.filters;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    /* Useful stuff for later development purposes.
    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;
    */

    @Override
    public void filter(ContainerRequestContext requestContext) {
        log.info("Request Headers :: {}", requestContext.getHeaders());
        log.info("Request Path :: {} {}", requestContext.getMethod(), requestContext.getUriInfo().getPath());
        byte[] bytes = readBytes(requestContext.getEntityStream());
        String body = convertBody(bytes) ;
        if(body.isEmpty()){
            return;
        }
        log.info("Request Body :: {}", body);
        requestContext.setEntityStream(new ByteArrayInputStream(bytes));
    }

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) {
        log.info("Response Status :: {} {}", responseContext.getStatus(), responseContext.getStatusInfo().toEnum().name());
        Object obj = responseContext.getEntity();
        if(Objects.nonNull(obj)){
            log.info("Response Body :: {}", obj);
        }
    }

    private String convertBody(byte[] inputBytes){
        ByteArrayInputStream bis = new ByteArrayInputStream(inputBytes);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        for (int result = bis.read(); result != -1; result = bis.read()) {
            buf.write((byte) result);
        }
        return buf.toString(StandardCharsets.UTF_8).replaceAll("[\n\r|^ +]", "");
    }

    private byte[] readBytes(InputStream stream){
        try{
            return stream.readAllBytes();
        } catch (IOException e){
            log.error("Error decoding request body");
            throw new RuntimeException("Error decoding request body");
        }
    }
}
