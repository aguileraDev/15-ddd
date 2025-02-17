package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;

public class OccupiedSpace extends DomainEvent {
    private final Integer coordinateX;
    private final Integer coordinateY;


    public OccupiedSpace(String spaceId, Integer coordinateX, Integer coordinateY) {
        super(EventsEnum.OCCUPIED_SPACE.name());
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;

    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }


}
