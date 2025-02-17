package com.arknova.zoo_administrator.domain.deck.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Type implements IValueObject {
    private final String value;

    private Type(String value) {
        this.value = value;
    }

    public static Type of(String value) {
        return new Type(value);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }
}
