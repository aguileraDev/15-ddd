package com.arknova.zoo_administrator.domain.deck.events;

import com.arknova.shared.domain.generic.DomainEvent;

import java.time.Instant;

public class ShuffleDeck extends DomainEvent {
    private final String deckId;
    private final Instant when;

    public ShuffleDeck(String deckId, Instant when) {
        super(EventsEnum.UPDATED_DECK.name());
        this.deckId = deckId;
        this.when = when;
    }

    public String getDeckId() {
        return deckId;
    }

    @Override
    public Instant getWhen() {
        return when;
    }
}
