package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;

public class PlacedAnimal extends DomainEvent {
    private final String animalId;
    private final String spaceId;
    private final Double currencyCost;
    private final String type;

    public PlacedAnimal(String animalId, String spaceId, Double currencyCost, String type) {
        super(EventsEnum.PLACED_ANIMAL.name());
        this.animalId = animalId;
        this.spaceId = spaceId;
        this.currencyCost = currencyCost;
        this.type = type;
    }


    public String getAnimalId() {
        return animalId;
    }

    public String getSpaceId() {
        return spaceId;
    }

    public Double getCurrencyCost() {
        return currencyCost;
    }

    public String getType() {
        return type;
    }
}
