package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.Identity;

public class ZoologicalId extends Identity {

    public ZoologicalId(){
        super();
    }

    private ZoologicalId(String id) {
        super(id);
    }

    public static ZoologicalId of(String id) {
        return new ZoologicalId(id);
    }
}
