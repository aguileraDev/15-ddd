package com.arknova.zoo_administrator.domain.zoological;

import com.arknova.shared.domain.generic.AggregateRoot;
import com.arknova.zoo_administrator.domain.zoological.entities.Animal;
import com.arknova.zoo_administrator.domain.zoological.entities.Project;
import com.arknova.zoo_administrator.domain.zoological.entities.Space;
import com.arknova.zoo_administrator.domain.zoological.entities.Tile;
import com.arknova.zoo_administrator.domain.zoological.events.ConstructedTile;
import com.arknova.zoo_administrator.domain.zoological.events.OccupiedSpace;
import com.arknova.zoo_administrator.domain.zoological.events.PlacedAnimal;
import com.arknova.zoo_administrator.domain.zoological.events.ProjectActivated;
import com.arknova.zoo_administrator.domain.zoological.values.Attractive;
import com.arknova.zoo_administrator.domain.zoological.values.Reputation;
import com.arknova.zoo_administrator.domain.zoological.values.Status;
import com.arknova.zoo_administrator.domain.zoological.values.ZoologicalId;

import java.util.ArrayList;
import java.util.List;

public class Zoological extends AggregateRoot<ZoologicalId> {

    private Reputation totalReputation;
    private Attractive totalAttractive;
    private List<Tile> tiles;
    private List<Animal> animals;
    private List<Space> spaces;
    private Project project;

    // region Constructors
    public Zoological(){
        super(new ZoologicalId());
        this.tiles = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.spaces = new ArrayList<>();
    }

    public Zoological(ZoologicalId identity, Reputation totalReputation, Attractive totalAttractive, List<Tile> tiles, List<Animal> animals, List<Space> spaces, Project project) {
        super(identity);
        this.totalReputation = totalReputation;
        this.totalAttractive = totalAttractive;
        this.tiles = tiles;
        this.animals = animals;
        this.spaces = spaces;
        this.project = project;
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

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
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
    // endregion

    // region Domain Actions
    public void houseAnimal(String animalId, String spaceId, Double currencyCost, String type){
        apply(new PlacedAnimal(animalId, spaceId, currencyCost, type));
    }

    public void activateProject(String projectId, String description){
        apply(new ProjectActivated(projectId, description));
    }

    public void takeUpSpace(String spaceId, Integer coordinateX, Integer coordinateY){
        apply(new OccupiedSpace(spaceId, coordinateX, coordinateY));
    }

    public void buildTile(String tileId, String spaceId, Integer level, Double cost){
        apply(new ConstructedTile(tileId, spaceId, level, cost));
    }

    // endregion
    // region Public Methods

    public void freeUpSpace(String spaceId){
        this.spaces.stream().filter(space -> space.getIdentity().equals(spaceId)).findFirst().get().setStatus(Status.of("FREE"));
    }
    public void freeUpAnimal(String animalId, String spaceId){
        this.animals.stream().filter(animal -> animal.getIdentity().getValue().equalsIgnoreCase(animalId)).findFirst().get().setStatus(Status.of("FREE"));
        freeUpSpace(spaceId);
    }

    //endregion
}
