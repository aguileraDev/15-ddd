package com.arknova.shared.domain.generic;

public abstract class Entity<I extends Identity> {

    private final I identity;

    protected Entity(final I identity){
        this.identity = identity;
    }

    public I getIdentity() {
        return identity;
    }
}
