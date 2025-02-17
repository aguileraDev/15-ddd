package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Region implements IValueObject {

    private final String value;

    private Region(final String value) {
        this.value = value;
        validate();
    }

    public static Region of(final String value) {
        return new Region(value);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }

    public String getValue() {
        return value;
    }
}
