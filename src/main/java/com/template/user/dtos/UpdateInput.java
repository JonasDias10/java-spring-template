package com.template.user.dtos;

import com.template.common.validations.email.LowercaseEmail;
import com.template.user.helpers.UserMessages;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateInput(
    String name,
    @Email(message = UserMessages.USER_INVALID_EMAIL) @LowercaseEmail String email,
    @Size(min = 6, message = UserMessages.USER_PASSWORD_MIN_LENGTH) String password) {}
