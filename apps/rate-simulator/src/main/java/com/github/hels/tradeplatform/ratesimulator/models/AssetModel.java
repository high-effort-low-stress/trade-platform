package com.github.hels.tradeplatform.ratesimulator.models;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MongoEntity(collection = "assets")
public class AssetModel {
    private String ticket;
    private BigDecimal initialValue;
    private BigDecimal currentValue;
    private double updateFrequency;
}
