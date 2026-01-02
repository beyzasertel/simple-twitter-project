package com.workitech.twitter.dto.response;

public record TweetResponseDto(
        Long id,
        String text,
        Long userId
) {
}
