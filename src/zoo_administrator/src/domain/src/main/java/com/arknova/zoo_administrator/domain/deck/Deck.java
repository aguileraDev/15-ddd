package com.arknova.zoo_administrator.domain.deck;


import com.arknova.shared.domain.generic.AggregateRoot;
import com.arknova.zoo_administrator.domain.deck.entities.Card;
import com.arknova.zoo_administrator.domain.deck.events.ActivatedCard;
import com.arknova.zoo_administrator.domain.deck.events.DiscardedCard;
import com.arknova.zoo_administrator.domain.deck.events.ShuffleDeck;
import com.arknova.zoo_administrator.domain.deck.values.DeckId;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck extends AggregateRoot<DeckId> {

    private List<Card> cards;
    private List<Card> discardPile;

    // region Constructors
    public Deck(){
        super(new DeckId());
        this.cards = new ArrayList<>();
    }
    private Deck(DeckId identity, List<Card> initialCards) {
        super(identity);
        this.cards = initialCards;
    }

    // endregion

    // region Getters and Setters

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;

    }
    // endregion

    //region Domain Actions
    public void shuffle() {
        Collections.shuffle(cards);
        apply(new ShuffleDeck(this.getIdentity().getValue(), Instant.now()));
    }

    public void activateCard(Card card) {
        if (card == null) {
            throw new IllegalArgumentException("La carta no puede ser nula");
        }
        cards.add(card);
        apply(new ActivatedCard(card.getIdentity().getValue(), this.getIdentity().getValue(), Instant.now()));
    }
    public void discardCard(Card card) {
        Boolean removed = cards.remove(card);
        if (!removed) {
            throw new IllegalStateException("La carta no se encuentra en el mazo");
        }
        discardPile.add(card);
        apply(new DiscardedCard(card.getIdentity().getValue(),this.getIdentity().getValue(), Instant.now()));
    }
    //endregion

    // region Public Methods

    //endregion
}
