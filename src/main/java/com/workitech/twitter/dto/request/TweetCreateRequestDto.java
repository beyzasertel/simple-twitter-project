package com.workitech.twitter.dto.request;

import jakarta.validation.constraints.NotBlank;

public record TweetCreateRequestDto(
        @NotBlank String text
) {
}
