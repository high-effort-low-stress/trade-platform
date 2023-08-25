package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InactiveUserService {
    private final IUserRepository repository;

    public User execute (Long id) {
        User user = repository.findById(id).orElse(null);

        if (Objects.isNull(user) || !user.isActive())
            return null;

        user.setActive(false);
        return repository.save(user);
    }
}
