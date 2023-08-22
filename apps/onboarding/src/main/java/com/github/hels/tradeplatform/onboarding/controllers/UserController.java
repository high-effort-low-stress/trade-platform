package com.github.hels.tradeplatform.onboarding.controllers;

import com.github.hels.tradeplatform.onboarding.dto.CreateUserDto;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import com.github.hels.tradeplatform.onboarding.service.CreateUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserService createUserService;
    private final IUserRepository iUserRepository;

    @PostMapping
    public CreateUserDto.Response createUser(
            @Valid @RequestBody CreateUserDto.Request requestBody
    ) {
        String name = requestBody.getName();
        String document = requestBody.getDocument();
        String email = requestBody.getEmail();
        String password = requestBody.getPassword();
        String phoneNumber = requestBody.getPhoneNumber();

        User user = createUserService.execute(name, document, email, password, phoneNumber);

        return new CreateUserDto.Response(user.getId().toString());
    }
    @GetMapping("/all")
    public List<User> findAll () {
        return iUserRepository.findAll();
    }
}