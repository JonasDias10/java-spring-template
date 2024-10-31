package com.template.user.dtos;

import com.template.common.validations.email.LowercaseEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record UpdateInput(
        String name,

        @Email(message = "Email inválido")
        @LowercaseEmail
        String email,

        @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
        String password
) {
}