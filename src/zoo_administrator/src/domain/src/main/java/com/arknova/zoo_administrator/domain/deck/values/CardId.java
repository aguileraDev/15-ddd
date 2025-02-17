package com.arknova.zoo_administrator.domain.deck.values;

import com.arknova.shared.domain.generic.Identity;


public class CardId extends Identity {

    public CardId(){
        super();
    }

    private CardId(String id) {
        super(id);
    }

    public static CardId of(String id) {
        return new CardId(id);
    }
}
