package com.arknova.zoo_administrator.domain.zoological;

import com.arknova.shared.domain.generic.DomainActionsContainer;
import com.arknova.shared.domain.generic.DomainEvent;
import com.arknova.zoo_administrator.domain.zoological.entities.Animal;
import com.arknova.zoo_administrator.domain.zoological.entities.Enclosure;
import com.arknova.zoo_administrator.domain.zoological.entities.Project;
import com.arknova.zoo_administrator.domain.zoological.entities.Space;
import com.arknova.zoo_administrator.domain.zoological.events.ConstructedEnclosure;
import com.arknova.zoo_administrator.domain.zoological.events.CreatedZoo;
import com.arknova.zoo_administrator.domain.zoological.events.OccupiedSpace;
import com.arknova.zoo_administrator.domain.zoological.events.PlacedAnimal;
import com.arknova.zoo_administrator.domain.zoological.events.ProjectActivated;
import com.arknova.zoo_administrator.domain.zoological.values.AnimalId;
import com.arknova.zoo_administrator.domain.zoological.values.Attractive;
import com.arknova.zoo_administrator.domain.zoological.values.Coordinate;
import com.arknova.zoo_administrator.domain.zoological.values.CurrencyCost;
import com.arknova.zoo_administrator.domain.zoological.values.Description;
import com.arknova.zoo_administrator.domain.zoological.values.EnclosureId;
import com.arknova.zoo_administrator.domain.zoological.values.HasBonus;
import com.arknova.zoo_administrator.domain.zoological.values.IsOccupied;
import com.arknova.zoo_administrator.domain.zoological.values.Level;
import com.arknova.zoo_administrator.domain.zoological.values.Name;
import com.arknova.zoo_administrator.domain.zoological.values.Region;
import com.arknova.zoo_administrator.domain.zoological.values.Reputation;
import com.arknova.zoo_administrator.domain.zoological.values.Reward;
import com.arknova.zoo_administrator.domain.zoological.values.Status;
import com.arknova.zoo_administrator.domain.zoological.values.Type;

import java.util.List;
import java.util.function.Consumer;

public class ZooHandler extends DomainActionsContainer {

    public ZooHandler(Zoological zoological) {
        add(createZoo(zoological));
        add(addAnimal(zoological));
        add(constructEnclosure(zoological));
        add(allocatedSpace(zoological));
        add(enabledProject(zoological));
    }

    public Consumer<? extends DomainEvent> createZoo(Zoological zoological) {
        return (CreatedZoo zoo) -> {
            zoological.setTotalAttractive(Attractive.of(0));
            zoological.setTotalReputation(Reputation.of(0));
        };
    }

    public Consumer<? extends DomainEvent> addAnimal(Zoological zoological) {
        return (PlacedAnimal event) -> {

            Animal animal = new Animal(
                    AnimalId.of(event.getAnimalId()),
                    Type.of(event.getType()),
                    Level.of(event.getLevel()),
                    Name.of(event.getName()),
                    Attractive.of(event.getAttractive()),
                    Region.of(event.getRegion()),
                    CurrencyCost.of(event.getCurrencyCost()),
                    Status.of("housed"));

            Enclosure enclosure = new Enclosure(Type.of(animal.getType().getValue()), Level.of(animal.getLevel().getValue()), IsOccupied.of(false));
            enclosure.houseAnimal(animal);

            zoological.constructedEnclosure(
                    enclosure.getIdentity().getValue(),
                    enclosure.getAnimals(),
                    enclosure.getAllocatedSpaces(),
                    enclosure.getType().getValue(),
                    enclosure.getLevel().getValue(),
                    enclosure.getBaseAttractive().getValue());


        };
    }

    public Consumer<? extends DomainEvent> constructEnclosure(Zoological zoological) {
        return (ConstructedEnclosure event) -> {
            final Double CONSTANT_COORDINATES_FACTOR_SIZE = 1.7;
            Enclosure newEnclosure = new Enclosure(
                    EnclosureId.of(event.getEnclosureId()),
                    List.copyOf(event.getAnimals()),
                    List.copyOf(event.getAllocatedSpaces()),
                    Type.of(event.getType()),
                    Level.of(event.getLevel()),
                    IsOccupied.of(true),
                    Attractive.of(event.getBaseAttractive()));

            Space space = new Space(
                    Coordinate.of(
                            newEnclosure.getLevel().getValue() * CONSTANT_COORDINATES_FACTOR_SIZE,
                            newEnclosure.getLevel().getValue() * (CONSTANT_COORDINATES_FACTOR_SIZE - 0.4)),
                    IsOccupied.of(false),
                    HasBonus.of(false),
                    newEnclosure
            );

            zoological.takeUpSpace(
                    space.getIdentity().getValue(),
                    newEnclosure,
                    space.getCoordinate().getPositionX(),
                    space.getCoordinate().getPositionY(),
                    space.getHasBonus().getValue()
                    );

            zoological.getEnclosures().add(newEnclosure);
            zoological.updateAttractive(newEnclosure.getBaseAttractive().getValue());
        };
    }

    public Consumer<? extends DomainEvent> allocatedSpace(Zoological zoological) {
        return (OccupiedSpace event) -> {
            Space space = new Space(
                    Coordinate.of(event.getCoordinateX(), event.getCoordinateY()),
                    IsOccupied.of(true),
                    HasBonus.of(event.getHasBonus()),
                    new Enclosure(
                            EnclosureId.of(event.getEnclosure().getIdentity().getValue()),
                            (event.getEnclosure().getAnimals()),
                            event.getEnclosure().getAllocatedSpaces(),
                            event.getEnclosure().getType(),
                            event.getEnclosure().getLevel(),
                            IsOccupied.of(true),
                            event.getEnclosure().getBaseAttractive()
            ));

            space.assignEnclosure(space.getEnclosure());
        };
    }

    public Consumer<? extends DomainEvent> enabledProject(Zoological zoological) {
        return (ProjectActivated event) -> {

            Project project = new Project(
                    Name.of("Corazon de la selva amazonas"),
                    Description.of("Tu zoologico debe haber alcanzado un cierto nivel de atractivo, " +
                            "lo que demuestra que es un establecimiento reconocido y respetado en el mundo"),
                    Reward.of("Reputation + 15%")
            );

            project.checkRequeriments(zoological);
            zoological.updateReputation(project.enabled());

        };
    }
}
