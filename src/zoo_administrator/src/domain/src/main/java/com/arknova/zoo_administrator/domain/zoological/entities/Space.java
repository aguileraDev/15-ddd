package com.arknova.zoo_administrator.domain.zoological.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.zoological.values.Coordinate;
import com.arknova.zoo_administrator.domain.zoological.values.SpaceId;
import com.arknova.zoo_administrator.domain.zoological.values.Status;

public class Space extends Entity<SpaceId> {
    private Coordinate coordinate;
    private Status status;

    public Space(SpaceId identity, Coordinate coordinate, Status status) {
        super(identity);
        this.coordinate = coordinate;
        this.status = status;
    }

    public Space(Coordinate coordinate, Status status) {
        super(new SpaceId());
        this.coordinate = coordinate;
        this.status = status;
    }


    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
