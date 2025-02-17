package com.arknova.zoo_administrator.domain.deck.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Requirement implements IValueObject {

    private final String value;

    private Requirement(final String value){
        this.value = value;
        validate();
    }

    public static Requirement of(final String value){
        return new Requirement(value);
    }
    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }

    public String getValue() {
        return value;
    }
}
