package com.arknova.zoo_administrator.domain.zoological.values;

import com.arknova.shared.domain.generic.Identity;

public class TileId extends Identity {

    public TileId(){
        super();
    }

    private TileId(String id) {
        super(id);
    }

    public static TileId of(String id) {
        return new TileId(id);
    }
}
