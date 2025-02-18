package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;


public class PlacedAnimal extends DomainEvent {
    private final String animalId;
    private final String enclosureId;
    private final String type;
    private final Integer level;
    private final String name;
    private final Integer attractive;
    private final String region;
    private final Double currencyCost;

    public PlacedAnimal(String animalId, String enclosureId, String type, Integer level, String name, Integer attractive, String region, Double currencyCost) {
        super(EventsEnum.PLACED_ANIMAL.name());
        this.animalId = animalId;
        this.enclosureId = enclosureId;
        this.type = type;
        this.level = level;
        this.name = name;
        this.attractive = attractive;
        this.region = region;
        this.currencyCost = currencyCost;
    }

    public String getAnimalId() {
        return animalId;
    }

    public String getEnclosureId() {
        return enclosureId;
    }

    public String getType() {
        return type;
    }

    public Integer getLevel() {
        return level;
    }

    @Override
    public String getName() {
        return name;
    }

    public Integer getAttractive() {
        return attractive;
    }

    public String getRegion() {
        return region;
    }

    public Double getCurrencyCost() {
        return currencyCost;
    }
}
