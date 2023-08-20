package com.github.hels.tradeplatform.ratesimulator.services;

public interface IApiService<I, O> {
    O execute(I input);
}
