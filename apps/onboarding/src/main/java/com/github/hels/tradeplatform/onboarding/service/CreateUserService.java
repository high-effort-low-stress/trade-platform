package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class CreateUserService {
    private final IUserRepository repository;

    public User execute(String name, String document, String email, String password, String phoneNumber, LocalDate birthDate) {

        isLegalAge(birthDate);
        isPhoneNumberValid(phoneNumber);
        isDuplicated(document, email, phoneNumber);


        User user = new User();

        user.setName(name);
        user.setDocument(document);
        user.setEmail(email);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        user.setPhoneNumber(phoneNumber);
        user.setBirthDate(birthDate);


        return repository.save(user);
    }

    private void isDuplicated (String document, String email, String phoneNumber) {
        if (repository.findByDocumentOrEmailOrPhoneNumber(
                document,
                email,
                phoneNumber
        ).isPresent()
        ) throw new ApiException("User already registered.");
    }
    private void isLegalAge (LocalDate dateOfBirth) {
        LocalDate currentDate = LocalDate.now();
        if(Period.between(dateOfBirth, currentDate).getYears() < 18)
            throw new ApiException("User must be 18+ years old");
    }
    private void isPhoneNumberValid (String phoneNumber) {
        Pattern p = Pattern.compile("\\d{4}9\\d{8}");
        Matcher m = p.matcher(phoneNumber);
        if (!m.find())
            throw  new ApiException("Phone number must be valid.");
    }
}
