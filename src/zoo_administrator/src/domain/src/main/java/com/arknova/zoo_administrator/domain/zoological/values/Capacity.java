package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Capacity implements IValueObject {
    private final Integer value;

    private Capacity(final Integer value) {
        this.value = value;
        validate();
    }

    public static Capacity of(final Integer value) {
        return new Capacity(value);
    }

    @Override
    public void validate() {
        Validators.validateValueGreaterThanZero(Double.valueOf(value));
    }

    public Integer getValue() {
        return value;
    }
}
