package com.github.hels.tradeplatform.ratesimulator.controllers;

import com.github.hels.tradeplatform.ratesimulator.dtos.CreateAssetDTO;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Path("v1/asset")
@Slf4j
@RequiredArgsConstructor
public class AssetController {

    @GET
    public String test() {
        return "Olá mundo";
    }

    @POST
    public CreateAssetDTO.Response create(CreateAssetDTO.Request request){
        log.info("{}", request);
        return null;
    }
}
