package com.arknova.zoo_administrator.domain.zoological.events;

import com.arknova.shared.domain.generic.DomainEvent;
import com.arknova.zoo_administrator.domain.zoological.entities.Animal;
import com.arknova.zoo_administrator.domain.zoological.entities.Space;

import java.util.List;

public class ConstructedEnclosure extends DomainEvent {
    private final String enclosureId;
    private final List<Animal> animals;
    private final List<Space> allocatedSpaces;
    private final String type;
    private final Integer level;
    private final Integer baseAttractive;

    public ConstructedEnclosure(String enclosureId,  List<Animal> animals, List<Space> allocatedSpaces,  String type, Integer level, Integer baseAttractive) {
        super(EventsEnum.CONSTRUCTED_ENCLOSURE.name());
        this.enclosureId = enclosureId;
        this.type = type;
        this.level = level;
        this.baseAttractive = baseAttractive;
        this.animals = animals;
        this.allocatedSpaces = allocatedSpaces;
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

    public Integer getBaseAttractive() {
        return baseAttractive;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public List<Space> getAllocatedSpaces() {
        return allocatedSpaces;
    }
}
