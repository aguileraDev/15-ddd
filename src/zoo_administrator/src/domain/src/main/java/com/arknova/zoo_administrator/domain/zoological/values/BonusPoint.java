package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class BonusPoint implements IValueObject {
    private final Integer value;

    private BonusPoint(final Integer value) {
        this.value = value;
        validate();
    }

    public static BonusPoint of(final Integer value) {
        return new BonusPoint(value);
    }

    @Override
    public void validate() {
        Validators.validateValueGreaterThanZero(Double.valueOf(value));
    }

    public Integer getValue() {
        return value;
    }
}
