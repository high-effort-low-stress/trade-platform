package com.github.hels.tradeplatform.onboarding.controllers;

import com.github.hels.tradeplatform.onboarding.dto.CreateUserDto;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import com.github.hels.tradeplatform.onboarding.service.CreateUserService;
import com.github.hels.tradeplatform.onboarding.service.InactiveUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final CreateUserService createUserService;
    private final IUserRepository iUserRepository;
    private final InactiveUserService inactiveUserService;

    @PostMapping
    public CreateUserDto.Response createUser(
            @Valid @RequestBody CreateUserDto.Request requestBody
    ) {
        String name = requestBody.getName();
        String document = requestBody.getDocument();
        String email = requestBody.getEmail();
        String password = requestBody.getPassword();
        String phoneNumber = requestBody.getPhoneNumber();
        LocalDate birthDate = requestBody.getBirthDate();

        User user = createUserService.execute(name, document, email, password, phoneNumber, birthDate);

        return new CreateUserDto.Response(user.getId().toString());
    }
    @GetMapping("/all")
    public List<User> findAll () {
        return iUserRepository.findAll();
    }
    @PatchMapping("/{id}")
    public String inactiveUser (
           @PathVariable Long id
    ) {
         inactiveUserService.execute(id);
        return "Usuário desativado com sucesso";
    }
}