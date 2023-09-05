package com.github.hels.tradeplatform.onboarding.dto.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class UserDto {
    private Long id;
    private String name;
    private String document;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
    private boolean isActive;
}
