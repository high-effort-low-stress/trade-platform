package com.github.hels.tradeplatform.onboarding.controllers;

import com.github.hels.tradeplatform.onboarding.dto.auth.LoginDto;
import com.github.hels.tradeplatform.onboarding.service.auth.GenerateTokenService;
import com.github.hels.tradeplatform.onboarding.service.auth.ValidateTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/login")
@RequiredArgsConstructor
public class LoginController {
    private final GenerateTokenService generateTokenService;
    private final ValidateTokenService validateTokenService;

    @PostMapping
    public LoginDto.Response generate(@RequestBody LoginDto.Request login){
        String token = generateTokenService.execute(login.getEmail(), login.getPassword());
        return new LoginDto.Response("Bearer " + token, 3600);
    }

    @PostMapping("validate")
    public void validate(@RequestHeader("Authorization") String token){
        validateTokenService.execute(token);
    }
}
