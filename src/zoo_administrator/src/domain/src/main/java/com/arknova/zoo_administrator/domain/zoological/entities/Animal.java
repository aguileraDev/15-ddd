package com.arknova.zoo_administrator.domain.zoological.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.zoological.values.AnimalId;
import com.arknova.zoo_administrator.domain.zoological.values.Attractive;
import com.arknova.zoo_administrator.domain.zoological.values.CurrencyCost;
import com.arknova.zoo_administrator.domain.zoological.values.Name;
import com.arknova.zoo_administrator.domain.zoological.values.Region;
import com.arknova.zoo_administrator.domain.zoological.values.Status;
import com.arknova.zoo_administrator.domain.zoological.values.Type;

public class Animal extends Entity<AnimalId> {

    private Type type;
    private Name name;
    private Attractive attractive;
    private Region region;
    private CurrencyCost currencyCost;
    private Status status;


    public Animal(AnimalId identity, Type type, Name name, Attractive attractive, Region region, CurrencyCost currencyCost, Status status) {
        super(identity);
        this.type = type;
        this.name = name;
        this.attractive = attractive;
        this.region = region;
        this.currencyCost = currencyCost;
        this.status = status;
    }

    public Animal( Type type, Name name, Attractive attractive, Region region, CurrencyCost currencyCost, Status status) {
        super(new AnimalId());
        this.type = type;
        this.name = name;
        this.attractive = attractive;
        this.region = region;
        this.currencyCost = currencyCost;
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Attractive getAttractive() {
        return attractive;
    }

    public void setAttractive(Attractive attractive) {
        this.attractive = attractive;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public CurrencyCost getCurrencyCost() {
        return currencyCost;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCurrencyCost(CurrencyCost currencyCost) {
        this.currencyCost = currencyCost;

    }


}
