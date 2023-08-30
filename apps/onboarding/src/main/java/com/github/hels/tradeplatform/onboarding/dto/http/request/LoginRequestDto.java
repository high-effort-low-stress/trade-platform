package com.github.hels.tradeplatform.onboarding.dto.http.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto{

    @NotBlank(message = "an email must be provided.")
    @Email(message = "Email must be valid.")
    @Pattern(regexp = ".*(\\w+\\.)+\\w+$", message = "Email must be valid.")
    private String email;

    @ToString.Exclude
    @NotBlank(message = "A password must be provided.")
    private String password;
}