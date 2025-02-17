package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Status implements IValueObject {
    private final String value;

    private Status(final String value) {
        this.value = value;
        validate();
    }

    public static Status of(final String value) {
        return new Status(value);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }

    public String getValue() {
        return value;
    }
}
