package com.filmflix.vodservice.utilities.mappers;

import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.enums.UserRole;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.dtos.requests.RegisterRequest;
import com.filmflix.vodservice.dtos.responses.UserResponse;
import com.filmflix.vodservice.utilities.exceptions.UserAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper {

    private final UserRepository userRepository;

    public User mapToEntity(RegisterRequest in) {
        userRepository.findByEmail(in.getUsername())
                .ifPresent(user -> {
                    throw new UserAlreadyExistsException(in.getUsername());
                });

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return User.builder()
                .email(in.getUsername())
                .password(passwordEncoder.encode(in.getPassword()))
                .blocked(false)
                .planPaid(false)
                .role(UserRole.USER)
                .build();
    }

    public UserResponse mapToResponse(User user) {
        return UserResponse.builder()
                .email(user.getEmail())
                .planPaid(user.isPlanPaid())
                .build();
    }

    public String encryptPassword(String passwordToEncrypt){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(passwordToEncrypt);
    }
}
