package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.dtos.requests.RegisterRequest;
import com.filmflix.vodservice.dtos.responses.UserResponse;
import com.filmflix.vodservice.utilities.exceptions.PasswordsDontMatchException;
import com.filmflix.vodservice.utilities.exceptions.UserNotFoundException;
import com.filmflix.vodservice.utilities.mappers.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static com.filmflix.vodservice.utilities.TestBuilders.buildUser;
import static com.filmflix.vodservice.utilities.TestConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserMapper userMapper;
    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        User user = buildUser();
        UserResponse userResponse = UserResponse.builder()
                .email(USER_TEST_EMAIL)
                .planPaid(false)
                .build();
        when(userRepository.save(any(User.class))).thenReturn(user);
        when(userRepository.findByEmail(USER_TEST_EMAIL)).thenReturn(Optional.of(user));
        when(userMapper.mapToEntity(any(RegisterRequest.class))).thenReturn(user);
        when(userMapper.mapToResponse(any(User.class))).thenReturn(userResponse);
    }

    @Test
    public void registerUser_shouldThrowPasswordsDontMatchException() {
        assertThrows(PasswordsDontMatchException.class, () ->
                userService.registerUser(buildRegisterRequest(USER_WRONG_REPEAT_PASS_TEST)));
    }

    @Test
    public void registerUser_shouldReturnUserResponse() {
        assertThat(userService.registerUser(buildRegisterRequest(USER_TEST_PASSWORD)))
                .isInstanceOf(UserResponse.class);
    }

    @Test
    public void getUser_shouldReturnUser(){
        User user = userService.getUser(USER_TEST_EMAIL);
        assertThat(user).isNotNull();
        assertThat(user.getUsername()).isEqualTo(USER_TEST_EMAIL);
    }

    @Test
    public void getUser_shouldThrowUserNotFoundException(){
        assertThrows(UserNotFoundException.class, () -> userService.getUser(USER_TEST_WRONG_EMAIL));
    }

    @Test
    public void loadUserByUsername_shouldReturnUserDetails(){
        UserDetails userDetails = userService.loadUserByUsername(USER_TEST_EMAIL);
        assertThat(userDetails).isNotNull();
        assertThat(userDetails.getUsername()).isEqualTo(USER_TEST_EMAIL);
    }

    @Test
    public void getUserResponse_shouldReturnUserResponse(){
        UserResponse userResponse = userService.getUserResponse(USER_TEST_EMAIL);
        assertThat(userResponse).isNotNull();
        assertThat(userResponse.getEmail()).isEqualTo(USER_TEST_EMAIL);
        assertThat(userResponse.isPlanPaid()).isEqualTo(false);
    }

    private RegisterRequest buildRegisterRequest(String password) {
        return RegisterRequest.builder()
                .username(USER_TEST_EMAIL)
                .password(USER_TEST_PASSWORD)
                .repeatPassword(password)
                .build();
    }
}
