package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.Identity;

public class SpaceId extends Identity {

    public SpaceId(){
        super();
    }

    private SpaceId(String id) {
        super(id);
    }

    public static SpaceId of(String id) {
        return new SpaceId(id);
    }
}
