package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.Identity;

public class EnclosureId extends Identity {

    public EnclosureId(){
        super();
    }

    private EnclosureId(String id) {
        super(id);
    }

    public static EnclosureId of(String id) {
        return new EnclosureId(id);
    }
}