package com.workitech.twitter.service;

import com.workitech.twitter.dto.request.LoginRequestDto;
import com.workitech.twitter.dto.request.RegisterRequestDto;
import com.workitech.twitter.dto.response.LoginResponseDto;
import com.workitech.twitter.dto.response.RegisterResponseDto;
import com.workitech.twitter.entity.User;
import com.workitech.twitter.exceptions.EmailAlreadyExists;
import com.workitech.twitter.exceptions.UserNotFoundException;
import com.workitech.twitter.exceptions.UsernameAlreadyExistException;
import com.workitech.twitter.mapper.UserMapper;
import com.workitech.twitter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final UserMapper userMapper;

    @Override
    public RegisterResponseDto register(RegisterRequestDto registerRequestDto) {

        if (userRepository.existsByUsername(registerRequestDto.username())) {
            throw new UsernameAlreadyExistException("Username already exists");
        }

        if (userRepository.existsByEmail(registerRequestDto.email())) {
            throw new EmailAlreadyExists("Email already exists");
        }

        // DTO → Entity
        User user = userMapper.toEntity(registerRequestDto);

        // Save
        User savedUser = userRepository.save(user);

        // Entity → Response DTO
        return userMapper.toResponseDto(savedUser);
    }

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(() -> new UserNotFoundException("Wrong email"));

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new UserNotFoundException("Wrong password");
        }

        return new LoginResponseDto(user.getEmail());
    }
}

