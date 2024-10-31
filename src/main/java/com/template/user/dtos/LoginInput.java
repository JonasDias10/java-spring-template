package com.template.user.dtos;

import com.template.common.validations.email.LowercaseEmail;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginInput(
        @Email(message = "Email inválido")
        @NotBlank(message = "Email é obrigatório")
        @LowercaseEmail
        String email,

        @Size(min = 6, message = "Senha deve ter pelo menos 6 caracteres")
        @NotBlank(message = "Senha é obrigatória")
        String password
) {
}
