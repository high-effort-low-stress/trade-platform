package com.github.hels.tradeplatform.onboarding.mappers;

import com.github.hels.tradeplatform.onboarding.dto.CreateUserDto;
import com.github.hels.tradeplatform.onboarding.models.User;
import org.mapstruct.Mapper;

@Mapper
public interface CreateUserRequest {

    CreateUserDto.Request toUserRequestDto (User entity);
}
