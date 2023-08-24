package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.Clock;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class CreateUserService {
    private final IUserRepository repository;
    private Clock clock = Clock.systemDefaultZone();

    public User execute(String name, String document, String email, String password, String phoneNumber, LocalDate birthDate) {

        isLegalAge(birthDate);
        isDuplicated(document, email, phoneNumber);

        if (Objects.isNull(password))
            throw new RuntimeException("Password can't be null.");

        User user = new User();

        user.setName(name);
        user.setDocument(document);
        user.setEmail(email);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        user.setPhoneNumber(phoneNumber);
        user.setBirthDate(birthDate);

        return repository.save(user);
    }

    private void isDuplicated(String document, String email, String phoneNumber) {
        List<User> users = repository.findDuplicates(document, email, phoneNumber);

        if (!users.isEmpty())
            throw new ApiException("User already registered.");
    }

    private void isLegalAge(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now(clock);

        if (Objects.isNull(birthDate))
            throw new RuntimeException("Birth date can't be null");

        if(Period.between(birthDate, currentDate).getYears() < 18)
            throw new ApiException("User must be 18+ years old");
    }
}
