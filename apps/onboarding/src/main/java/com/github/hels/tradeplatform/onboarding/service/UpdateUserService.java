package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class UpdateUserService {
    private final IUserRepository repository;

    public User execute (Long id, String email, String phoneNumber) {
        User user = repository.findById(id).orElse(null);

        if (Objects.isNull(user) || !user.isActive())
            return null;

        if (!email.isBlank() || !phoneNumber.isBlank()) {
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        }

        return repository.save(user);
    }


}
