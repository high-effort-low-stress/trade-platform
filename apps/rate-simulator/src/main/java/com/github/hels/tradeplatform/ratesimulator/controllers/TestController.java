package com.github.hels.tradeplatform.ratesimulator.controllers;

import com.github.hels.tradeplatform.ratesimulator.dtos.Stock;
import com.github.hels.tradeplatform.ratesimulator.services.SimulateStockPricingService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;

@Path("test")
@RequiredArgsConstructor
public class TestController {
    private final SimulateStockPricingService service;
    @GET
    public String test(){
        service.execute(new Stock());
        return "Olá mundo";
    }
}
