package com.github.hels.tradeplatform.onboarding.service;

import com.github.hels.tradeplatform.onboarding.models.User;
import com.github.hels.tradeplatform.onboarding.repository.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class InactiveUserServiceTest {
    private final IUserRepository repository = mock(IUserRepository.class);
    private final InactiveUserService service = new InactiveUserService(repository);

    @Test
    @DisplayName("should inactive user if user is active")
    void shouldInactiveUserIfUserIsActive() {
        User user = new User();
        user.setActive(true);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        doReturn(new User()).when(repository).save(any());
        doReturn(Optional.of(user)).when(repository).findById(any());

        User result = service.execute(any());

        verify(repository, times(1)).save(userArgumentCaptor.capture());

        Assertions.assertFalse(userArgumentCaptor.getValue().isActive());
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("should return null if user is null")
    void shouldReturnNullIfUserIsNull() {
        Optional<User> userNull = Optional.empty();

        when(repository.findById(any())).thenReturn(userNull);

        User result = service.execute(any());

        Assertions.assertNull(result);
    }

    @Test
    @DisplayName("Should return null if user is inactive")
    void shouldReturnNullifUserIsInactive() {
        User user = new User();
        user.setActive(false);

        when(repository.findById(any())).thenReturn(Optional.of(user));

        User result = service.execute(any());

        verify(repository, times(1)).findById(any());

        Assertions.assertNull(result);
    }

}
