package com.workitech.twitter.dto.response;

public record RegisterResponseDto(
        String username,
        String email,
        String name,
        String surname
) {
}
