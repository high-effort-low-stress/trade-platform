package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.models.Address;
import com.github.hels.tradeplatform.onboarding.repository.IAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddressService {

    private final IAddressRepository repository;

    public Address execute(Address entity) {

        return repository.save(entity);
    }
}
