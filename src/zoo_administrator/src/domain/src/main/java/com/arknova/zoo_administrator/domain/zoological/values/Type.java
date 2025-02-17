package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Type implements IValueObject {
    private final String value;

    private Type(final String value) {
        this.value = value;
        validate();
    }

    public static Type of(final String value) {
        return new Type(value);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }

    public String getValue() {
        return value;
    }
}
