package com.workitech.twitter.controller;


import com.workitech.twitter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

}
