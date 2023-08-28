package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.db.specifications.ApiSpecification;
import com.github.hels.tradeplatform.db.specifications.Input;
import com.github.hels.tradeplatform.db.specifications.Operator;
import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginUserService {
    private final IUserRepository repository;

    public void execute(String email, String password){

        User user = repository.findAll(buildSpecification(email))
                .stream()
                .findFirst()
                .orElseThrow((() -> new ApiException("Usuário ou senha não correspondem")));

        if (!BCrypt.checkpw(password, user.getPassword())){
            throw new ApiException("Usuário ou senha não correspondem");
        }


    }

    private ApiSpecification<User> buildSpecification(String email){
        Input<User> input = new Input<>();
        input.addRootField("email", Operator.EQUAL, email)
                .addRootField("isActive", Operator.EQUAL, true);

        return ApiSpecification.<User>builder()
                .input(input)
                .build();
    }

}
