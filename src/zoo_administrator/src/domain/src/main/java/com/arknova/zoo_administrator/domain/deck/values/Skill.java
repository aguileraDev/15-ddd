package com.arknova.zoo_administrator.domain.deck.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Skill implements IValueObject {
    private final String value;

    private Skill(final String value){
        this.value = value;
        validate();
    }

    public static Skill of(final String value){
        return new Skill(value);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(value);
    }

    public String getValue() {
        return value;
    }
}
