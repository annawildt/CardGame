package com.wildt;

public class PlayingCard {

    static final String[] cardSuit = {"Clubs", "Diamonds", "Hearts", "Spades"};
    static final String[] cardRank = {"Ace", "Two", "Three", "Four", "Five", "Six",
    "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

    boolean hidden;

    int suit;
    int rank;

    public PlayingCard(int suit, int rank, boolean hidden) {
        this.rank = rank;
        this.suit = suit;
        this.hidden = hidden;
    }

    public String generateCard() {
        //Method to return a string with the cards color and number
        return cardRank[rank] + " of " + cardSuit[suit];
    }
}
