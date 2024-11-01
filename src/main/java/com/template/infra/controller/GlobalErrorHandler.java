package com.template.infra.controller;

import com.template.common.GlobalMessages;
import com.template.common.dtos.ErrorMessage;
import com.template.common.exceptions.BusinessException;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalErrorHandler {
    private final Logger logger = org.slf4j.LoggerFactory.getLogger(GlobalErrorHandler.class);

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handleException(@NonNull BusinessException businessException) {
        logger.error("BusinessException: {}", businessException.getMessage());

        return ResponseEntity.badRequest().body(new ErrorMessage(businessException.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleException(@NonNull MethodArgumentNotValidException exception) {
        logger.error("MethodArgumentNotValidException: {}", exception.getMessage());

        var errors = exception.getBindingResult().getFieldErrors();

        return ResponseEntity.badRequest().body(new ErrorMessage(errors.getFirst().getDefaultMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(@NonNull Exception exception) {
        logger.error("Exception: {}", exception.getMessage());

        return ResponseEntity.internalServerError().body(new ErrorMessage(GlobalMessages.DEFAULT_ERROR_MESSAGE));
    }

}
