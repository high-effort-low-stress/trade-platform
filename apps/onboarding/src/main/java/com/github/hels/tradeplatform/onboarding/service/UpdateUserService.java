package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
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
            throw new ApiException("Usuário não encontrado");

        if (Objects.nonNull(email)  && !email.isBlank()) {
            user.setEmail(email);
        }

        if (Objects.nonNull(phoneNumber) && !phoneNumber.isBlank()) {
            user.setPhoneNumber(phoneNumber);
        }

        return repository.save(user);
    }

}


