package com.filmflix.vodservice.controllers;

import com.filmflix.vodservice.configurations.security.jwt.JwtUtil;
import com.filmflix.vodservice.dtos.requests.LoginRequest;
import com.filmflix.vodservice.dtos.requests.RegisterRequest;
import com.filmflix.vodservice.dtos.responses.TokenResponse;
import com.filmflix.vodservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081",
        "http://localhost:8082", "http://localhost:8083"})
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userDetailService;
    private final JwtUtil jwtTokenUtil;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest user) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailService.loadUserByUsername(user.getUsername());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new TokenResponse(jwt));
    }

    @PostMapping(value = "/register", consumes = "application/json")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest registerRequest) {
        userDetailService.registerUser(registerRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
