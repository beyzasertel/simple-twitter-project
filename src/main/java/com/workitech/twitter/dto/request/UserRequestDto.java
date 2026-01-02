package com.workitech.twitter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record UserRequestDto(
        @Size(max = 30)
        @NotBlank
        @NotEmpty
        @NotNull
        @JsonProperty("username")
        String username,

        @Size(max = 30)
        @Email
        @NotBlank
        @NotEmpty
        @NotNull
        @JsonProperty("email")
        String email,

        @Size(max = 30)
        @NotBlank
        @NotEmpty
        @NotNull
        @JsonProperty("password")
        String password,

        @Size(max = 30)
        @NotBlank
        @NotEmpty
        @NotNull
        @JsonProperty("name")
        String name,

        @Size(max = 30)
        @NotBlank
        @NotEmpty
        @NotNull
        @JsonProperty("surname")
        String surname
) {


}
