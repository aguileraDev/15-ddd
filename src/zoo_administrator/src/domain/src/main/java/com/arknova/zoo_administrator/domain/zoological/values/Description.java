package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Description implements IValueObject {
    private final String text;

    private Description(final String text) {
        this.text = text;
        validate();
    }

    public static Description of(final String text) {
        return new Description(text);
    }

    @Override
    public void validate() {
        Validators.validateTextNotEmptyOrBlank(text);
    }

    public String getText() {
        return text;
    }
}
