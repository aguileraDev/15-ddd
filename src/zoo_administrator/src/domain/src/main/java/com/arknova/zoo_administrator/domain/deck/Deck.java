package com.arknova.zoo_administrator.domain.deck;


import com.arknova.shared.domain.generic.AggregateRoot;
import com.arknova.zoo_administrator.domain.deck.entities.Card;
import com.arknova.zoo_administrator.domain.deck.events.ActivatedCard;
import com.arknova.zoo_administrator.domain.deck.events.DiscardedCard;
import com.arknova.zoo_administrator.domain.deck.events.UpdatedDeck;
import com.arknova.zoo_administrator.domain.deck.values.DeckId;

import java.util.ArrayList;
import java.util.List;

public class Deck extends AggregateRoot<DeckId> {

    private List<Card> cards;

    // region Constructors

    public Deck(){
        super(new DeckId());
        this.cards = new ArrayList<>();
    }
    private Deck(DeckId identity, List<Card> cards) {
        super(identity);
        this.cards = cards;
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
        apply(new UpdatedDeck(this.getIdentity().getValue()));
    }

    public void activateCard(String cardId){
        apply(new ActivatedCard(cardId));
    }
    public void discardCard(String cardId){
        apply(new DiscardedCard(cardId));
    }
    //endregion

    // region Public Methods

    //endregion
}
