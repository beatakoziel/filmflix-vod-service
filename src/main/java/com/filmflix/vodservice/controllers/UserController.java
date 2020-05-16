package com.filmflix.vodservice.controllers;

import com.filmflix.vodservice.db.entities.User;
import com.filmflix.vodservice.dtos.responses.UserResponse;
import com.filmflix.vodservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:8080", "http://localhost:8081",
        "http://localhost:8082", "http://localhost:8083"})
public class UserController {

    private final UserService userService;

    @GetMapping
    public UserResponse getUserData(Authentication authentication){
        return userService.getUserResponse(((User) authentication.getPrincipal()).getUsername());
    }

    @PostMapping("/pay")
    public void addOpinion(Authentication authentication) {
        userService.payStreamingPlan(((User) authentication.getPrincipal()).getUsername());
    }
}
