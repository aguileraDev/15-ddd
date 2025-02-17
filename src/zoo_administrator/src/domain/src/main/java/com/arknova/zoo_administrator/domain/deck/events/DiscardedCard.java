package com.arknova.zoo_administrator.domain.deck.events;

import com.arknova.shared.domain.generic.DomainEvent;

public class DiscardedCard extends DomainEvent {
    private final String cardId;

    public DiscardedCard(String cardId) {
        super(EventsEnum.DISCARDED_CARD.name());
        this.cardId = cardId;

    }

}
