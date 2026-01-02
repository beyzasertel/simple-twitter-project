package com.workitech.twitter.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

public record LoginRequestDto(@Size(max = 50)
                              @Email
                              @NotBlank
                              @NotEmpty
                              @NotNull
                              @JsonProperty("email")
                              String email,

                              @Size(max = 50)
                              @NotBlank
                              @NotEmpty
                              @NotNull
                              @JsonProperty("password")
                              String password) {
}
