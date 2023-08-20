package com.github.hels.tradeplatform.ratesimulator.repositories;

import com.github.hels.tradeplatform.ratesimulator.models.AssetModel;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class AssetRepository implements PanacheMongoRepository<AssetModel> {
    public Optional<AssetModel> findByTicket(String ticket){
        return find("ticket", ticket).firstResultOptional();
    }
}
