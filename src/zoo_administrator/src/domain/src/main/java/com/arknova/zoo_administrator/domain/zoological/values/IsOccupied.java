package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class IsOccupied implements IValueObject {
    private final Boolean value;

    private IsOccupied(final Boolean value) {
        this.value = value;
        validate();
    }

    public static IsOccupied of(final Boolean value) {
        return new IsOccupied(value);
    }

    @Override
    public void validate() {
        Validators.validateNotNull(value);
    }

    public Boolean getValue() {
        return value;
    }
}
