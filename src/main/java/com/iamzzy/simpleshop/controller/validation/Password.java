package com.iamzzy.simpleshop.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
    String message() default "Password must be at least 8 characters long, contain an uppercase letter, a lowercase letter, a number, and a special character";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
