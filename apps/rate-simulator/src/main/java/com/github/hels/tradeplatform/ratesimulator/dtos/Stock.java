package com.github.hels.tradeplatform.ratesimulator.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Stock extends AbstractAsset{
    private static final double BASE_VOLATILITY = 3.0;

    @Override
    public double getBaseVolatility() {
        return BASE_VOLATILITY;
    }
}
