package com.github.hels.tradeplatform.ratesimulator.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class AbstractAsset {
    protected String ticket;
    protected double volatility;
    protected double frequency;

    abstract protected double getBaseVolatility();

}
