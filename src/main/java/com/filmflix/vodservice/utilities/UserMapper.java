package com.filmflix.vodservice.utilities;

import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.db.enums.UserRole;
import com.filmflix.vodservice.db.repositories.UserRepository;
import com.filmflix.vodservice.dtos.RegisterRequest;
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
}
