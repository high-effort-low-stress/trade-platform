package com.github.hels.tradeplatform.ratesimulator.services;

import com.github.hels.tradeplatform.ratesimulator.dtos.Stock;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ApplicationScoped
public class SimulateStockPricingService implements IApiService<Stock, Void> {

    @Override
    public Void execute(Stock stock) {
        log.info("{}", stock.getBaseVolatility());
        return null;
    }
}
