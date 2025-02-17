package com.arknova.shared.domain.utils;

public class Validators {

    public static void validateValueGreaterThanZero(Double value) {
        validateNotNull(value);

        if (value <= 0) {
            throw new IllegalArgumentException("Value cannot be less than zero.");
        }
    }

    public static void validateNotNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null.");
        }
    }

    public static void validateTextNotEmptyOrBlank(String text){
        if(text.isEmpty() || text.isBlank()){
            throw new IllegalArgumentException("Text cannot be empty or blank.");
        }
    }
}
