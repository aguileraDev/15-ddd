package com.arknova.zoo_administrator.domain.zoological.entities;

import com.arknova.shared.domain.generic.Entity;
import com.arknova.zoo_administrator.domain.zoological.values.Level;
import com.arknova.zoo_administrator.domain.zoological.values.Status;
import com.arknova.zoo_administrator.domain.zoological.values.TileId;
import com.arknova.zoo_administrator.domain.zoological.values.Type;

public class Tile extends Entity<TileId> {

    private Type type;
    private Level level;
    private Status status;

    public Tile(TileId identity, Type type, Level level, Status status) {
        super(identity);
        this.type = type;
        this.level = level;
        this.status = status;
    }

    public Tile(Type type, Level level, Status status) {
        super(new TileId());
        this.type = type;
        this.level = level;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
