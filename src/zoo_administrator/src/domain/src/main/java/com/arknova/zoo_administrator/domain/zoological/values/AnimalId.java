package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.Identity;

public class AnimalId extends Identity {

    public AnimalId(){
        super();
    }

    private AnimalId(String id) {
        super(id);
    }

    public static AnimalId of(String id) {
        return new AnimalId(id);
    }
}
