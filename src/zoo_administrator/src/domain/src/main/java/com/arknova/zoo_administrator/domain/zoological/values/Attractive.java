package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Attractive implements IValueObject {
    private final Double value;

    private Attractive(final Double value) {
        this.value = value;
        validate();
    }

    public static Attractive of(final Double value) {
        return new Attractive(value);
    }

    @Override
    public void validate() {
        Validators.validateValueGreaterThanZero(value);
    }

    public Double getValue() {
        return value;
    }

}
