package com.github.hels.tradeplatform.onboarding.mappers;

import com.github.hels.tradeplatform.onboarding.dto.http.response.LoginResponseDto;
import com.github.hels.tradeplatform.onboarding.dto.output.LoginOutputDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginMapper {

    LoginResponseDto toResponse(LoginOutputDto output);
}
