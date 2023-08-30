package com.github.hels.tradeplatform.onboarding.service.auth;

import com.github.hels.tradeplatform.onboarding.dto.output.LoginOutputDto;
import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
import com.github.hels.tradeplatform.onboarding.http.security.JwtTokenUtil;
import com.github.hels.tradeplatform.onboarding.mappers.UserMapper;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.*;

public class GenerateTokenServiceTest {
    private final IUserRepository repository = mock(IUserRepository.class);
    private final JwtTokenUtil jwtTokenUtil = mock(JwtTokenUtil.class);
    private final UserMapper userMapper = spy(UserMapper.class);

    private final GenerateTokenService service = new GenerateTokenService(
            repository,
            jwtTokenUtil,
            userMapper
    );

    User sampleUser(){
        User user = new User();
        user.setPassword(BCrypt.hashpw("password", BCrypt.gensalt()));
        return user;
    }

    @Test
    @DisplayName("should throw if user is not found")
    void shouldThrowIfUserIsNotFound(){

        doReturn(List.of()).when(repository).findAll(Mockito.<Specification<User>>any());

        ApiException ex = Assertions.assertThrows(
                ApiException.class,
                () -> service.execute("email", "password")
        );

        Assertions.assertEquals("Usuário ou senha não correspondem", ex.getMessage());
    }

    @Test
    @DisplayName("should throw if password does not match")
    void shouldThrowIfPasswordDoesNotMatch(){
        User user = sampleUser();

        doReturn(List.of(user)).when(repository).findAll(Mockito.<Specification<User>>any());

        ApiException ex = Assertions.assertThrows(
                ApiException.class,
                () -> service.execute("email", "errada")
        );

        Assertions.assertEquals("Usuário ou senha não correspondem", ex.getMessage());
    }

    @Test
    @DisplayName("should return token and expiration timestamp if successful")
    void shouldReturnTokenAndExpirationTimestampIfSuccessful(){
        User user = sampleUser();

        LocalDateTime expiresAt = LocalDateTime
                .of(2023,8,30,20,40,0);

        doReturn(List.of(user)).when(repository).findAll(Mockito.<Specification<User>>any());
        doReturn("token").when(jwtTokenUtil).generateToken(any());
        doReturn(expiresAt).when(jwtTokenUtil).getExpirationDateFromToken(any());


        LoginOutputDto dto = service.execute("email", "password");

        verify(jwtTokenUtil, times(1)).generateToken(any());
        verify(jwtTokenUtil, times(1)).getExpirationDateFromToken(any());

        Assertions.assertEquals("token", dto.getToken());
        Assertions.assertEquals(1693428000, dto.getExpiresAt());
    }
}
