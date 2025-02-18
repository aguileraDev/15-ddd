package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;
import com.arknova.zoo_administrator.domain.zoological.entities.Enclosure;

public class OccupiedSpace extends DomainEvent {
    private final String spaceId;
    private final Enclosure enclosure;
    private final Double coordinateX;
    private final Double coordinateY;
    private final Boolean hasBonus;


    public OccupiedSpace(String spaceId, Enclosure enclosure, Double coordinateX, Double coordinateY, Boolean hasBonus) {
        super(EventsEnum.OCCUPIED_SPACE.name());
        this.spaceId = spaceId;
        this.enclosure = enclosure;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.hasBonus = hasBonus;

    }

    public String getSpaceId() {
        return spaceId;
    }

    public Double getCoordinateX() {
        return coordinateX;
    }

    public Double getCoordinateY() {
        return coordinateY;
    }

    public Enclosure getEnclosure() {
        return enclosure;
    }

    public Boolean getHasBonus() {
        return hasBonus;
    }
}
