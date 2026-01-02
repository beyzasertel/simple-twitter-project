package com.workitech.twitter.controller;

import com.workitech.twitter.dto.request.RegisterRequestDto;
import com.workitech.twitter.dto.request.TweetCreateRequestDto;
import com.workitech.twitter.dto.request.TweetUpdateRequestDto;
import com.workitech.twitter.dto.response.RegisterResponseDto;
import com.workitech.twitter.dto.response.TweetResponseDto;
import com.workitech.twitter.service.TweetService;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED) // 201
    public TweetResponseDto create(
            @Valid @RequestBody TweetCreateRequestDto tweetCreateRequestDto,
            Authentication authentication
    ) {
        String email = authentication.getName();
        return tweetService.create(tweetCreateRequestDto, email);
    }

    @GetMapping("/findByUserId")
    public List<TweetResponseDto> findByUserId(@RequestParam Long userId) {
        return tweetService.findByUserId(userId);
    }

    @GetMapping("/findById")
    public TweetResponseDto findById(@RequestParam Long id) {
        return tweetService.findById(id);
    }

    @PutMapping("/{id}")
    public TweetResponseDto update(
            @PathVariable Long id,
            @RequestBody @Valid TweetUpdateRequestDto dto
    ) {
        return tweetService.update(dto.text(), id);
    }

    @PostMapping("/delete")
    public void deleteById(@RequestParam Long id) {
        tweetService.deleteById(id);
    }

}
