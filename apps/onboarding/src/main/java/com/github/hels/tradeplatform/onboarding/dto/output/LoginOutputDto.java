package com.github.hels.tradeplatform.onboarding.dto.output;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginOutputDto{
    private String token;
    private Long expiresAt;
}