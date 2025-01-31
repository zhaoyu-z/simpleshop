package com.iamzzy.simpleshop.controller.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    /**
     * 1. length greater than 8 characters
     * 2. must have at least 1 number
     * 3. must have at least 1 uppercase letter
     * 4. must have at least 1 lowercase letter
     * 5. must have at least 1 special character from [@#$%^&+=!.]
     */
    private static final String PASSWORD_PATTERN =
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!.]).{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }
        return pattern.matcher(password).matches();
    }
}
