package com.arknova.zoo_administrator.domain.zoological;

import com.arknova.shared.domain.generic.AggregateRoot;
import com.arknova.shared.domain.generic.DomainEvent;
import com.arknova.zoo_administrator.domain.zoological.entities.Animal;
import com.arknova.zoo_administrator.domain.zoological.entities.Project;
import com.arknova.zoo_administrator.domain.zoological.entities.Space;
import com.arknova.zoo_administrator.domain.zoological.entities.Enclosure;
import com.arknova.zoo_administrator.domain.zoological.events.ConstructedEnclosure;
import com.arknova.zoo_administrator.domain.zoological.events.CreatedZoo;
import com.arknova.zoo_administrator.domain.zoological.events.OccupiedSpace;
import com.arknova.zoo_administrator.domain.zoological.events.PlacedAnimal;
import com.arknova.zoo_administrator.domain.zoological.events.ProjectActivated;
import com.arknova.zoo_administrator.domain.zoological.values.Attractive;
import com.arknova.zoo_administrator.domain.zoological.values.Reputation;
import com.arknova.zoo_administrator.domain.zoological.values.ZoologicalId;

import java.util.ArrayList;
import java.util.List;

public class Zoological extends AggregateRoot<ZoologicalId> {

    private Reputation totalReputation;
    private Attractive totalAttractive;
    private List<Enclosure> enclosures;
    private List<Animal> animals;
    private List<Space> spaces;
    private Project project;

    // region Constructors
    public Zoological(){
        super(new ZoologicalId());
        this.enclosures = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.spaces = new ArrayList<>();
        subscribe(new ZooHandler(this));
        apply(new CreatedZoo());
    }

    public Zoological(ZoologicalId identity, Reputation totalReputation, Attractive totalAttractive, List<Enclosure> enclosures, List<Animal> animals, List<Space> spaces, Project project) {
        super(identity);
        this.totalReputation = totalReputation;
        this.totalAttractive = totalAttractive;
        this.enclosures = enclosures;
        this.animals = animals;
        this.spaces = spaces;
        this.project = project;
    }

    private Zoological(ZoologicalId identity) {
        super(identity);
        subscribe(new ZooHandler(this));
    }
    // endregion

    // region Getters and Setters

    public Reputation getTotalReputation() {
        return totalReputation;
    }

    public void setTotalReputation(Reputation totalReputation) {
        this.totalReputation = totalReputation;
    }

    public Attractive getTotalAttractive() {
        return totalAttractive;
    }

    public void setTotalAttractive(Attractive totalAttractive) {
        this.totalAttractive = totalAttractive;
    }


    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Space> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<Space> spaces) {
        this.spaces = spaces;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Enclosure> getEnclosures() {
        return enclosures;
    }

    public void setEnclosures(List<Enclosure> enclosures) {
        this.enclosures = enclosures;
    }
    // endregion

    // region Domain Actions
    public void houseAnimal(String animalId, String enclosureId, String type, Integer level, String name, Integer attractive, String region, Double currencyCost){
        apply(new PlacedAnimal(animalId, enclosureId, type, level, name, attractive, region, currencyCost));
    }

    public void constructedEnclosure(String enclosureId, List<Animal> animals, List<Space> allocatedSpaces, String type, Integer level, Integer baseAttractive){
        apply(new ConstructedEnclosure(enclosureId, animals, allocatedSpaces, type, level, baseAttractive));
    }

    public void activateProject(String projectId, String description, String reward, Integer bonusPoint){
        apply(new ProjectActivated(projectId, description, reward, bonusPoint));
    }

    public void takeUpSpace(String spaceId, Enclosure enclosure, Double coordinateX, Double coordinateY, Boolean hasBonus){
        apply(new OccupiedSpace(spaceId, enclosure, coordinateX, coordinateY, hasBonus));
    }


    // endregion
    // region Public Methods

    public void updateAttractive(Integer attractivePoints){
        this.totalAttractive = Attractive.of(this.totalAttractive.getValue() + attractivePoints);
    }

    public void updateReputation(Integer reputationPoints){
        this.totalReputation = Reputation.of(totalReputation.getValue() + reputationPoints);
    }

    //endregion

    public static Zoological from(final String identity, final List<DomainEvent> events) {
        Zoological zoological = new Zoological (ZoologicalId.of(identity));

        events.forEach(zoological::apply);
        return zoological;
    }
}
