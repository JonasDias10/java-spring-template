package com.template.user.dtos;

import com.template.common.validations.email.LowercaseEmail;
import com.template.user.helpers.UserMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterInput(
    @NotBlank(message = UserMessages.USER_NAME_REQUIRED) String name,
    @Email(message = UserMessages.USER_INVALID_EMAIL)
        @NotBlank(message = UserMessages.USER_EMAIL_REQUIRED)
        @LowercaseEmail
        String email,
    @Size(min = 6, message = UserMessages.USER_PASSWORD_MIN_LENGTH)
        @NotBlank(message = UserMessages.USER_PASSWORD_REQUIRED)
        String password) {}
