package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.dtos.requests.RegisterRequest;
import com.filmflix.vodservice.dtos.responses.UserResponse;
import com.filmflix.vodservice.utilities.exceptions.PasswordsDontMatchException;
import com.filmflix.vodservice.utilities.exceptions.UserNotFoundException;
import com.filmflix.vodservice.utilities.mappers.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserResponse registerUser(RegisterRequest registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getRepeatPassword()))
            throw new PasswordsDontMatchException();
        return userMapper.mapToResponse(userRepository.save(userMapper.mapToEntity(registerRequest)));
    }

    public UserResponse changeUserPassword(String username, String newPassword) {
        User user = getUser(username);
        user.setPassword(userMapper.encryptPassword(newPassword));
        return (userMapper.mapToResponse(userRepository.save(user)));
    }

    public UserResponse payStreamingPlan(String username) {
        User user = getUser(username);
        user.setPlanPaid(true);
        return (userMapper.mapToResponse(userRepository.save(user)));
    }

    public User getUser(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    public UserResponse getUserResponse(String username) {
        return userMapper.mapToResponse(getUser(username));
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        return userRepository.findByEmail(s)
                .orElseThrow(() -> new UserNotFoundException(s));
    }

}
