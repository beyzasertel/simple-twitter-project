package com.workitech.twitter.service;

import com.workitech.twitter.dto.request.LoginRequestDto;
import com.workitech.twitter.dto.request.RegisterRequestDto;
import com.workitech.twitter.dto.response.LoginResponseDto;
import com.workitech.twitter.dto.response.RegisterResponseDto;

public interface AuthService {

    RegisterResponseDto register(RegisterRequestDto registerRequestDto);

    LoginResponseDto login(LoginRequestDto loginRequestDto);

}
