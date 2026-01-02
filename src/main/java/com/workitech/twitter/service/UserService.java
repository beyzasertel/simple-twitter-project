package com.workitech.twitter.service;

import com.workitech.twitter.dto.response.RegisterResponseDto;
import com.workitech.twitter.entity.User;

import java.util.List;

public interface UserService {

    User getByEmail(String email);

}
