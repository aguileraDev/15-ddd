package com.arknova.zoo_administrator.domain.deck;

import com.arknova.shared.domain.generic.DomainActionsContainer;
import com.arknova.shared.domain.generic.DomainEvent;
import com.arknova.zoo_administrator.domain.deck.events.ActivatedCard;
import com.arknova.zoo_administrator.domain.deck.events.DiscardedCard;
import com.arknova.zoo_administrator.domain.deck.events.ShuffleDeck;

import java.util.function.Consumer;

public class DeckHandler extends DomainActionsContainer {
    public DeckHandler(Deck deck){
        add(shuffle(deck));
        add(activateCard(deck));
        add(discardCard(deck));
    }

    public Consumer<? extends DomainEvent> shuffle(Deck deck){
        return (ShuffleDeck event) -> {

        };
    }

    public Consumer<? extends DomainEvent> activateCard(Deck deck) {
        return (ActivatedCard event) -> {
        };
    }

    public Consumer<? extends DomainEvent> discardCard(Deck deck) {
        return (DiscardedCard event) -> {
        };
    }
}
