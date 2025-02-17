package com.arknova.zoo_administrator.domain.deck.events;

import com.arknova.shared.domain.generic.DomainEvent;


public class ActivatedCard extends DomainEvent {
    private final String cardId;


    public ActivatedCard(String cardId) {
        super(EventsEnum.ACTIVATED_CARD.name());
        this.cardId = cardId;

    }

    public String getCardId() {
        return cardId;
    }

}
