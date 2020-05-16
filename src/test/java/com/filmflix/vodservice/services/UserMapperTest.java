package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.dtos.responses.UserResponse;
import com.filmflix.vodservice.utilities.exceptions.UserAlreadyExistsException;
import com.filmflix.vodservice.utilities.mappers.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.filmflix.vodservice.utilities.TestBuilders.buildRegisterRequest;
import static com.filmflix.vodservice.utilities.TestBuilders.buildUser;
import static com.filmflix.vodservice.utilities.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserMapperTest {

    @InjectMocks
    private UserMapper userMapper;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = buildUser();
        when(userRepository.findByEmail(USER_TEST_EMAIL)).thenReturn(Optional.of(user));
    }

    @Test
    public void mapToEntity_shouldThrowUserAlreadyExists() {
        assertThrows(UserAlreadyExistsException.class,
                () -> userMapper.mapToEntity(buildRegisterRequest(USER_TEST_EMAIL, USER_TEST_PASSWORD)));
    }

    @Test
    public void mapToEntity_shouldReturnUser() {
        User user = userMapper.mapToEntity(buildRegisterRequest(USER_DIFFERENT_EMAIL, USER_TEST_PASSWORD));
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(USER_DIFFERENT_EMAIL);
        assertThat(user.isPlanPaid()).isEqualTo(false);
        assertThat(user.isBlocked()).isEqualTo(false);
    }

    @Test
    public void mapToResponse_shouldReturnUserResponse() {
        UserResponse userResponse = userMapper.mapToResponse(buildUser());
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.isPlanPaid()).isEqualTo(false);
        assertThat(userResponse.getEmail()).isEqualTo(USER_TEST_EMAIL);
    }
}
