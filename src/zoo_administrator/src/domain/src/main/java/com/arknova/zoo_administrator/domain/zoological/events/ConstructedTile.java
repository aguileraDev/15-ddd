package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;

public class ConstructedTile extends DomainEvent {
    private final String tileId;
    private final String spaceId;
    private final Integer level;
    private final Double cost;

    public ConstructedTile(String tileId, String spaceId, Integer level, Double cost) {
        super(EventsEnum.CONSTRUCTED_TILE.name());
        this.tileId = tileId;
        this.spaceId = spaceId;
        this.level = level;
        this.cost = cost;
    }

    public String getTileId() {
        return tileId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public Integer getLevel() {
        return level;
    }

    public Double getCost() {
        return cost;
    }
}
