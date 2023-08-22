package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateUserService {
    private final IUserRepository repository;

    public User execute(String name, String document, String email, String password, String phoneNumber) {
        User user = new User();
        user.setName(name);
        user.setDocument(document);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);

        return repository.save(user);
    }
}
