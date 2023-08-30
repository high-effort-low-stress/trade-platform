package com.github.hels.tradeplatform.onboarding.controllers;

import com.github.hels.tradeplatform.onboarding.docs.auth.LoginApi;
import com.github.hels.tradeplatform.onboarding.dto.http.request.LoginRequestDto;
import com.github.hels.tradeplatform.onboarding.dto.http.response.LoginResponseDto;
import com.github.hels.tradeplatform.onboarding.dto.output.LoginOutputDto;
import com.github.hels.tradeplatform.onboarding.mappers.LoginMapper;
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
    private final LoginMapper mapper;

    @LoginApi
    @PostMapping
    public LoginResponseDto generate(@RequestBody LoginRequestDto login){
        LoginOutputDto output = generateTokenService.execute(login.getEmail(), login.getPassword());
        return mapper.toResponse(output);
    }

    @PostMapping("validate")
    public void validate(@RequestHeader("Authorization") String token){
        validateTokenService.execute(token);
    }
}
