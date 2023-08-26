package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import com.github.hels.tradeplatform.specifications.ApiSpecification;
import com.github.hels.tradeplatform.specifications.Input;
import com.github.hels.tradeplatform.specifications.Operator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginUserService {
    private final IUserRepository repository;

    public void execute(String email, String password){
        Input<User> input = new Input<>();
        input.addRootField("email", Operator.EQUAL, email)
                .addRootField("password", Operator.EQUAL, password)
                .addRootField("isActive", Operator.EQUAL, true);



        List<User> users = repository.findAll(ApiSpecification.<User>builder()
                .input(input)
                .build());
    }


}
