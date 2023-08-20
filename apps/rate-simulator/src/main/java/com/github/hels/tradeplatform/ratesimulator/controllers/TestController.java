package com.github.hels.tradeplatform.ratesimulator.controllers;

import com.github.hels.tradeplatform.ratesimulator.dtos.Stock;
import com.github.hels.tradeplatform.ratesimulator.services.SimulateStockPricingService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@Path("test")
@RequiredArgsConstructor
public class TestController {
    private final SimulateStockPricingService service;
    @GET
    public Map<String,String> test(){
        service.execute(new Stock());
        return Map.of("message","Olá mundo");
    }
}
