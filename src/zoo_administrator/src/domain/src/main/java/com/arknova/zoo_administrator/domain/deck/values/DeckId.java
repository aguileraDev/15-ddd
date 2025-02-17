package com.arknova.zoo_administrator.domain.deck.values;

import com.arknova.shared.domain.generic.Identity;


public class DeckId extends Identity {

    public DeckId(){
        super();
    }

    private DeckId(String id) {
        super(id);
    }

    public static DeckId of(String id) {
        return new DeckId(id);
    }
}
