package com.arknova.zoo_administrator.domain.zoological.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.zoological.values.Attractive;
import com.arknova.zoo_administrator.domain.zoological.values.Capacity;
import com.arknova.zoo_administrator.domain.zoological.values.IsOccupied;
import com.arknova.zoo_administrator.domain.zoological.values.Level;
import com.arknova.zoo_administrator.domain.zoological.values.EnclosureId;
import com.arknova.zoo_administrator.domain.zoological.values.Type;

import java.util.ArrayList;
import java.util.List;

public class Enclosure extends Entity<EnclosureId> {

    private List<Animal> animals;
    private List<Space> allocatedSpaces;
    private Type type;
    private Capacity capacity;
    private Level level;
    private IsOccupied isOccupied;
    private Attractive baseAttractive;

    public Enclosure(EnclosureId identity, List<Animal> animals, List<Space> allocatedSpaces, Type type, Level level, IsOccupied occupied, Attractive baseAttractive) {
        super(identity);
        this.type = type;
        this.level = level;
        this.isOccupied = occupied;
        this.animals = animals;
        this.allocatedSpaces = allocatedSpaces;
        this.baseAttractive = baseAttractive;
    }

    public Enclosure(Type type, Level level, IsOccupied occupied) {
        super(new EnclosureId());
        this.type = type;
        this.level = level;
        this.isOccupied = occupied;
        this.baseAttractive = Attractive.of(0);
        this.animals = new ArrayList<>();
        this.allocatedSpaces = new ArrayList<>();
    }

    public void houseAnimal(Animal animal) {
        if (animals.size() >= capacity.getValue()) {
            throw new IllegalStateException("El recinto ha alcanzado su capacidad maxima");
        }
        animals.add(animal);
        baseAttractive = Attractive.of(calculateAttractive());
    }

    public void removeAnimal(Animal animal) {
        if (!animals.remove(animal)) {
            throw new IllegalStateException("El animal no se encuentra en este recinto");
        }

        animals.remove(animal);
        baseAttractive = Attractive.of(calculateAttractive());
    }

    public Integer calculateAttractive() {
        return baseAttractive.getValue() + (animals.size() * 5);
    }

    public void allocateSpace(Space space) {
        if (!space.isAvailable()) {
            throw new IllegalStateException("Espacio no disponible");
        }
        allocatedSpaces.add(space);
        space.assignEnclosure(this);
}

    public Attractive getBaseAttractive() {
        return baseAttractive;
    }

    public void setBaseAttractive(Attractive baseAttractive) {
        this.baseAttractive = baseAttractive;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Capacity getCapacity() {
        return capacity;
    }

    public void setCapacity(Capacity capacity) {
        this.capacity = capacity;
    }

    public IsOccupied getIsOccupied() {
        return isOccupied;
    }

    public void setIsOccupied(IsOccupied isOccupied) {
        this.isOccupied = isOccupied;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Space> getAllocatedSpaces() {
        return allocatedSpaces;
    }

    public void setAllocatedSpaces(List<Space> allocatedSpaces) {
        this.allocatedSpaces = allocatedSpaces;
    }
}
