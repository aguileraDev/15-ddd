package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class IsActive implements IValueObject {
    private final Boolean value;

    private IsActive(final Boolean value){
        this.value = value;
        validate();
    }

    public static IsActive of(final Boolean value){
        return new IsActive(value);
    }

    @Override
    public void validate() {
        Validators.validateNotNull(value);
    }

    public Boolean getValue() {
        return value;
    }
}
