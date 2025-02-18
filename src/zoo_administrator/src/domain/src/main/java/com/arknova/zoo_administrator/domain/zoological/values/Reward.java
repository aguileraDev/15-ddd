package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Reward implements IValueObject {
    private final String value;

    private Reward(final String value) {
        this.value = value;
        validate();
    }

    public static Reward of(final String value) {
        return new Reward(value);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }

    public String getValue() {
        return value;
    }
}
