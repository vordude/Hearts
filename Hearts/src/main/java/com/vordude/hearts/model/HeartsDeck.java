package com.vordude.hearts.model;

import com.vordude.trike.Card;
import com.vordude.trike.Deck;
import com.vordude.trike.Rank;
import com.vordude.trike.Suit;

import java.util.Iterator;

public class HeartsDeck extends Deck {
    public HeartsDeck() {
        super();
        Iterator suitIterator = Suit.VALUES.iterator();
        while ( suitIterator.hasNext() ) {
            Suit suit = (Suit) suitIterator.next();
            Iterator rankIterator = Rank.VALUES.iterator();
            while ( rankIterator.hasNext() ) {
                Rank rank = (Rank) rankIterator.next();
                Card card = new Card(suit, rank);
                addCard(card);
            }
        }
        shuffle();
    }
}
