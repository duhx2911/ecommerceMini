package com.shopapi.ecommerceMini.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class VietnamesePhoneValidator implements ConstraintValidator<VietnamesePhone, String> {

    private static final Pattern PATTERN = Pattern.compile("^(0|\\+84)(3|5|7|8|9)\\d{8}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;   // null để @NotBlank xử lý, theo đúng quy tắc ở mục 2
        }
        return PATTERN.matcher(value).matches();
    }
}

