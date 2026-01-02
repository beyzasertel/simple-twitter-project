package com.workitech.twitter.service;

import com.workitech.twitter.dto.response.RegisterResponseDto;
import com.workitech.twitter.entity.User;
import com.workitech.twitter.exceptions.UserNotFoundException;
import com.workitech.twitter.mapper.UserMapper;
import com.workitech.twitter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserMapper userMapper;


    @Override
    public User getByEmail(String email){
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + email));
    }
}
