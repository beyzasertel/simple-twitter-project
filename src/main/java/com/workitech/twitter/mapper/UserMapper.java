package com.workitech.twitter.mapper;

import com.workitech.twitter.dto.request.RegisterRequestDto;
import com.workitech.twitter.dto.response.RegisterResponseDto;
import com.workitech.twitter.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    public User toEntity(RegisterRequestDto registerRequestDto) {
        User user = new User();
        user.setUsername(registerRequestDto.username());
        user.setEmail(registerRequestDto.email());

        user.setPassword(passwordEncoder.encode(registerRequestDto.password()));

        user.setName(registerRequestDto.name());
        user.setSurname(registerRequestDto.surname());

        return user;
    }


    public RegisterResponseDto toResponseDto(User user) {
        return new RegisterResponseDto(user.getUsername(), user.getEmail(), user.getName(), user.getSurname());
    }

}
