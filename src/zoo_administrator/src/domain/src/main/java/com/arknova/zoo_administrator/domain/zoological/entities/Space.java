package com.arknova.zoo_administrator.domain.zoological.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.zoological.values.Coordinate;
import com.arknova.zoo_administrator.domain.zoological.values.HasBonus;
import com.arknova.zoo_administrator.domain.zoological.values.IsOccupied;
import com.arknova.zoo_administrator.domain.zoological.values.SpaceId;

public class Space extends Entity<SpaceId> {
    private Coordinate coordinate;
    private HasBonus hasBonus;
    private Enclosure enclosure;
    private IsOccupied isOccupied;

    public Space(SpaceId identity, Coordinate coordinate, IsOccupied isOccupied, HasBonus hasBonus, Enclosure enclosure) {
        super(identity);
        this.coordinate = coordinate;
        this.isOccupied = isOccupied;
        this.hasBonus = hasBonus;
        this.enclosure = enclosure;
    }

    public Space(Coordinate coordinate, IsOccupied isOccupied, HasBonus hasBonus, Enclosure enclosure) {
        super(new SpaceId());
        this.coordinate = coordinate;
        this.isOccupied = isOccupied;
        this.hasBonus = hasBonus;
        this.enclosure = enclosure;
    }


    public boolean isAvailable() {
        return !isOccupied.getValue();
    }


    public void assignEnclosure(Enclosure newEnclosure) {
        if (isOccupied.getValue()) {
            throw new IllegalStateException("Espacio ocupado");
        }
        this.enclosure = newEnclosure;
        setIsOccupied(IsOccupied.of(true));
    }

    public void release() {
        if (!isOccupied.getValue()) {
        this.enclosure = null;
        setIsOccupied(IsOccupied.of(false));
        }
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public IsOccupied getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(IsOccupied isOccupied) {
        this.isOccupied = isOccupied;
    }

    public HasBonus getHasBonus() {
        return hasBonus;
    }

    public void setHasBonus(HasBonus hasBonus) {
        this.hasBonus = hasBonus;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;
    }
}
