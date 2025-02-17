package com.arknova.zoo_administrator.domain.deck.events;

import com.arknova.shared.domain.generic.DomainEvent;

public class UpdatedDeck extends DomainEvent {
    private final String deckId;

    public UpdatedDeck(String deckId) {
        super(EventsEnum.UPDATED_DECK.name());
        this.deckId = deckId;
    }
}
