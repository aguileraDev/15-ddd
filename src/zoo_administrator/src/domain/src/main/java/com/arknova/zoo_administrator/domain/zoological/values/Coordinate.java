package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.IValueObject;
import com.arknova.shared.domain.utils.Validators;

public class Coordinate implements IValueObject {
    private final Double positionX;
    private final Double positionY;

    private Coordinate(final Double positionX, final Double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        validate();
    }

    public static Coordinate of(final Double positionX, final Double positionY) {
        return new Coordinate(positionX, positionY);
    }

    @Override
    public void validate() {
        Validators.validateValueGreaterThanZero(positionX);
        Validators.validateValueGreaterThanZero(positionY);
    }

    public Double getPositionX() {
        return positionX;
    }

    public Double getPositionY() {
        return positionY;
    }
}
