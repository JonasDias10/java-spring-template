package com.template.common.validations.email;

import com.template.user.helpers.UserMessages;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = LowercaseEmailValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LowercaseEmail {
    String message() default UserMessages.USER_EMAIL_LOWERCASE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
