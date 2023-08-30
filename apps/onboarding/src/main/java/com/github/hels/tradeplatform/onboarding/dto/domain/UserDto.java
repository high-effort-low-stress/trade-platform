package com.github.hels.tradeplatform.onboarding.dto.domain;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private String name;
    private String document;
    private String email;
    @ToString.Exclude
    private String password;
    private String phoneNumber;
    private LocalDate birthDate;
    private boolean isActive;
}
