package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class HasBonus implements IValueObject {
    private final Boolean value;

    private HasBonus(final Boolean value){
        this.value = value;
        validate();
    }

    public static HasBonus of(final Boolean value){
        return new HasBonus(value);
    }

    @Override
    public void validate() {
        Validators.validateNotNull(value);
    }

    public Boolean getValue() {
        return value;
    }
}
