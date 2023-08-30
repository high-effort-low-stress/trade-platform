package com.github.hels.tradeplatform.onboarding.dto.http.response;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto{
    private String token;
    private Long expiresAt;
}