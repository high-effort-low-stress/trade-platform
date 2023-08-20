package com.github.hels.tradeplatform.ratesimulator.filters;

import io.quarkus.logging.Log;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {

    /* Useful stuff for later development purposes.
    @Context
    UriInfo info;

    @Context
    HttpServerRequest request;
    */

    @Override
    public void filter(ContainerRequestContext requestContext) {
        Log.info("Request Headers :: " + requestContext.getHeaders());
        Log.info(requestContext.getMethod());
        Log.info(requestContext.getUriInfo().getPath());
        Log.info(requestContext);
    }

    @Override
    public void filter(ContainerRequestContext requestContext,
                       ContainerResponseContext responseContext) {
        Log.info(responseContext);
    }
}
