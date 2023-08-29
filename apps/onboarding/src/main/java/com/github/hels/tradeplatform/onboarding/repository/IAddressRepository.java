package com.github.hels.tradeplatform.onboarding.repository;

import com.github.hels.tradeplatform.onboarding.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
