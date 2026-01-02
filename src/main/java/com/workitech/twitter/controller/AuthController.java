package com.workitech.twitter.controller;

import com.workitech.twitter.dto.request.LoginRequestDto;
import com.workitech.twitter.dto.request.RegisterRequestDto;
import com.workitech.twitter.dto.response.LoginResponseDto;
import com.workitech.twitter.dto.response.RegisterResponseDto;
import com.workitech.twitter.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public RegisterResponseDto register(
            @Valid @RequestBody RegisterRequestDto registerRequestDto
    ) {
        return authService.register(registerRequestDto);
    }

    @PostMapping("/login")
    public LoginResponseDto login(
            @Valid @RequestBody LoginRequestDto loginRequestDto
    ) {
       return authService.login(loginRequestDto);
    }

}
