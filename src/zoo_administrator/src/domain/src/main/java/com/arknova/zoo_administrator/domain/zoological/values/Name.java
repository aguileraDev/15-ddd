package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Name implements IValueObject {

    private final String value;

    private Name(final String value) {
        this.value = value;
        validate();
    }

    public static Name of(final String value) {
        return new Name(value);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }

    public String getValue() {
        return value;
    }
}
