package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.exceptions.ApiException;
import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UpdateUserServiceTest {

    @InjectMocks
    UpdateUserService service;

    @Mock
    IUserRepository repository;

    User user;
    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    @DisplayName("Should update user info if user exists and is active")
    void shouldUpdateUserInfoIfUserExistsAndIsActive() {
        user.setActive(true);
        user.setEmail("email@gmail.com");
        user.setPhoneNumber("5521987654321");
        userCaptor = ArgumentCaptor.forClass(User.class);

        doReturn(new User()).when(repository).save(any());
        doReturn(Optional.of(user)).when(repository).findById(any());

        User result = service.execute(any(), "emailupdate@gmail.com", "5522987654321");

        verify(repository, times(1)).save(userCaptor.capture());

        assertNotNull(result);
        assertEquals(user.getEmail(), userCaptor.getValue().getEmail());
        assertEquals(user.getPhoneNumber(), userCaptor.getValue().getPhoneNumber());
    }

    @Test
    @DisplayName("Should update user phone number if user exists and is active")
    void shouldUpdateUserPhoneNumberIfUserExistsAndIsActive() {
        user.setActive(true);
        user.setPhoneNumber("5521987654321");
        userCaptor = ArgumentCaptor.forClass(User.class);

        doReturn(new User()).when(repository).save(any());
        doReturn(Optional.of(user)).when(repository).findById(any());

        User result = service.execute(any(), null, "5522987654321");

        verify(repository, times(1)).save(userCaptor.capture());

        assertNotNull(result);
        assertEquals(user.getEmail(), userCaptor.getValue().getEmail());
        assertEquals(user.getPhoneNumber(), userCaptor.getValue().getPhoneNumber());
    }
    @Test
    @DisplayName("Should update user email if user exists and is active")
    void shouldUpdateUserEmailIfUserExistsAndIsActive() {
        user.setActive(true);
        user.setEmail("email@gmail.com");
        userCaptor = ArgumentCaptor.forClass(User.class);

        doReturn(new User()).when(repository).save(any());
        doReturn(Optional.of(user)).when(repository).findById(any());

        User result = service.execute(any(), "emailUpdate@gmail.com", null);

        verify(repository, times(1)).save(userCaptor.capture());

        assertNotNull(result);
        assertEquals(user.getEmail(), userCaptor.getValue().getEmail());
        assertEquals(user.getPhoneNumber(), userCaptor.getValue().getPhoneNumber());
    }

    @Test
    @DisplayName("Should throw exception if user does not exists or inactive")
    void shouldThrowExceptionIfUserDoesNotExistsOrInactive() {
        User user = new User();
        user.setActive(false);

        final ApiException e = assertThrows(ApiException.class,
                () -> service.execute(null, null, null));

        verify(repository, times(1)).findById(any());

        assertThat(e, notNullValue());
        assertThat(e.getMessage(), is ("Usuário não encontrado"));
        assertThat(e.getCause(), nullValue());
    }
}