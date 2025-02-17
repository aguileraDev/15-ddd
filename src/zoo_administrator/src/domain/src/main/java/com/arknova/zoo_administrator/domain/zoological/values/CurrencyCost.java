package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class CurrencyCost implements IValueObject {
    private final Double value;

    private CurrencyCost(final Double value) {
        this.value = value;
        validate();
    }

    public static CurrencyCost of(final Double value) {
        return new CurrencyCost(value);
    }

    @Override
    public void validate() {
        Validators.validateValueGreaterThanZero(value);
    }
    public Double getValue() {
        return value;
    }

}
