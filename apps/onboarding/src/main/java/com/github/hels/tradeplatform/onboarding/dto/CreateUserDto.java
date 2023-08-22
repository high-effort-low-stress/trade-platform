package com.github.hels.tradeplatform.onboarding.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class CreateUserDto {

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Request {
        private String name;
        private String document;
        private String email;
        private String password;
        private String phoneNumber;

    }

    @ToString
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Response {
        private String id;
    }
}
