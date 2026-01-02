package com.workitech.twitter.service;

import com.workitech.twitter.dto.request.TweetCreateRequestDto;
import com.workitech.twitter.dto.response.TweetResponseDto;

import java.util.List;

public interface TweetService {

    TweetResponseDto create(TweetCreateRequestDto tweetCreateRequestDto, String email);

    List<TweetResponseDto> findByUserId(Long userId);

    TweetResponseDto findById(Long id);

    TweetResponseDto update(String text,Long id);

    void deleteById(Long id);
}
