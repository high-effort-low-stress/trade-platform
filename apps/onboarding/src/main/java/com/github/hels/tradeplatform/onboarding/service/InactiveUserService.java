package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InactiveUserService {
    private final IUserRepository repository;
    private final HttpServletResponse response;

    public void execute (Long id) {
        User user = repository.getReferenceById(id);
        if (!user.isActive())
            response.setStatus(204);

        user.setActive(false);
       repository.save(user);
    }


    }
