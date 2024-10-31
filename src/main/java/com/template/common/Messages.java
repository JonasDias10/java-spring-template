package com.template.common;

import lombok.Getter;

@Getter
public enum Messages {
    DEFAULT_ERROR_MESSAGE("Um erro inesperado aconteceu, tente novamente mais tarde."),
    USER_NOT_FOUND("Usuário não encontrado."),
    USER_NOT_FOUND_BY_EMAIL("O email informado não existe."),
    USER_EMAIL_ALREADY_EXISTS("O email informado está em uso."),
    USER_ALREADY_EXISTS("Usuário já existe."),
    USER_INVALID_CREDENTIALS("Email ou senha inválidos."),
    ERROR_AUTHENTICATING_USER("Erro ao autenticar o usuário."),
    USER_INVALID_TOKEN("Token inválido.");

    private final String message;

    Messages(String s) {
        this.message = s;
    }

}
