package com.github.hels.tradeplatform.onboarding.controllers;

import com.github.hels.tradeplatform.onboarding.dto.LoginDto;
import com.github.hels.tradeplatform.onboarding.service.LoginUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/login")
@RequiredArgsConstructor
public class LoginController {
    private final LoginUserService loginUserService;


    @PostMapping
    public void authenticate(@RequestBody LoginDto.Request login){
        loginUserService.execute(login.getEmail(), login.getPassword());
    }
}
