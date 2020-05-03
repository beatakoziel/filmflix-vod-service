package com.filmflix.vodservice.services;

import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.dtos.RegisterRequest;
import com.filmflix.vodservice.utilities.PasswordsDontMatchException;
import com.filmflix.vodservice.utilities.UserMapper;
import com.filmflix.vodservice.utilities.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void registerUser(RegisterRequest registerRequest) {
        if (!registerRequest.getPassword().equals(registerRequest.getRepeatPassword()))
            throw new PasswordsDontMatchException();
        userRepository.save(userMapper.mapToEntity(registerRequest)).getId();
    }

    public User getUser(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    @Override
    public UserDetails loadUserByUsername(String s) {
        return userRepository.findByEmail(s)
                .orElseThrow(() -> new UserNotFoundException(s));
    }

}
