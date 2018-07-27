package com.wildt;

import java.util.ArrayList;
import java.util.List;

public class PlayingCardDeck {
    public List<PlayingCard> cardDeck;

    public PlayingCardDeck() {

        cardDeck = new ArrayList<>();

        //Creates PlayingCard-objects into cardDeck-Array with all numbers of cards for each color
        for (int suit = 0; suit <= PlayingCard.cardSuit.length-1; suit++) {
            for (int rank = 0; rank <= PlayingCard.cardRank.length-1; rank++) {
                PlayingCard addCard = new PlayingCard(suit, rank, true);
                cardDeck.add(addCard);
            }
        }
    }

    public PlayingCard getFirstCard(PlayingCardDeck deck) {
        //Method to get first card and then iterate through the deck
        try {
            PlayingCard drawnCard = cardDeck.get(0);

            PlayingCardDeck.putCardAtBottom(deck);
            return drawnCard;
        }
        catch (IndexOutOfBoundsException e){
            return null;
        }
    }

    public static void putCardAtBottom(PlayingCardDeck deck) {
        PlayingCard removeCard = deck.cardDeck.get(0);
        deck.cardDeck.remove(0);
        deck.cardDeck.add(removeCard);
    }
}

/* represent a card deck of 52 card of the type PlayingCard
At least one data structure for storing PlayingCard objects (array, hashmap, linkedlist etc.
Method to take the first card from PlayingCardDeck (array[i], key, etc)
Method to put a card into the back of the deck
Handle what happens when the deck is empty
 */