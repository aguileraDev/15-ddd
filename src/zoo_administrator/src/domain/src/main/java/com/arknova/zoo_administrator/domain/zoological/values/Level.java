package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Level implements IValueObject {

    private final Integer value;

    private Level(final Integer value) {
        this.value = value;
        validate();
    }

    public static Level of(final Integer value) {
        return new Level(value);
    }

    @Override
    public void validate() {
        Validators.validateValueGreaterThanZero(Double.valueOf(value));
    }

    public Integer getValue() {
        return value;
    }
}
