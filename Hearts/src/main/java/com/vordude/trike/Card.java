package com.vordude.trike;

import android.graphics.drawable.Drawable;

import com.vordude.hearts.R;

//Based on Card.java - John K. Estell - 8 May 2003
//Implementation of a playing card.  Uses classes Rank and Suit for card's value.



/**
 * Representation of a single playing card. A card consists of a suit value
 * (e.g. hearts, spades), a rank value (e.g. ace, 7, king), and an image of
 * the front of the card.  A card object is immutable; once instantiated, the
 * values cannot change.
 */
public class Card implements Comparable {
    private Suit suit;
    private Rank rank;

    /**
     * Creates a new playing card.
     * @param suit the suit value of this card.
     * @param rank the rank value of this card.
     */
    public Card( Suit suit, Rank rank ) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Returns the suit of the card.
     * @return a Suit constant representing the suit value of the card.
     */
    public Suit getSuit() {
        return this.suit;
    }

    /**
     * Returns the rank of the card.
     * @return a Rank constant representing the rank value of the card.
     */
    public Rank getRank() {
        return this.rank;
    }

    /**
     * Returns a description of this card.
     * @return the name of the card.
     */
    public String toString() {
        return rank.toString() + " of " + suit.toString();
    }


    /**
     * Returns a description of the rank of this card.
     * @return the rank value of the card as a string.
     */
    public String rankToString() {
        return rank.toString();
    }


    /**
     * Returns a description of the suit of this card.
     * @return the suit value of the card as a string.
     */
    public String suitToString() {
        return suit.toString();
    }

    /**
     * Compares two cards for the purposes of sorting.
     * Cards are ordered first by their suit value, then by their
     * rank value.
     * @param otherCardObject the other card
     * @return a negative integer, zero, or a positive integer is this card is
     * less than, equal to, or greater than the referenced card.
     */
    public int compareTo( Object otherCardObject ) {
        Card otherCard = (Card) otherCardObject;
        int suitDiff = suit.compareTo( otherCard.suit );
        int rankDiff = rank.compareTo( otherCard.rank );
        if ( suitDiff != 0 ) {
            return suitDiff;
        }
        else {
            return rankDiff;
        }
    }

    /**
     * Compares two cards to determine if they have the same value.
     * This is not the same as the use of <code>equals</code> which compares
     * two objects for equality.
     * @param card the other card
     * @return <code>true</code> if the two cards have the same rank and suit
     * values, <code>false</code> if they do not.
     */
    public boolean isSameAs( Card card ) {
        if ( ( rank != card.rank ) || ( suit != card.suit ) )
            return false;
        else
            return true;
    }

}