package com.github.hels.tradeplatform.onboarding.repository;

import com.github.hels.tradeplatform.onboarding.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByDocumentOrEmailOrPhoneNumber (
            String document,
            String email,
            String phoneNumber);

}
