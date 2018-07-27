package com.wildt;

import java.util.Random;

public class PlayingCardDeck {
    public PlayingCard[] cardDeck;
    int deckNumber;
    int firstCard = 0;

    public PlayingCardDeck() {

        deckNumber = 51;
        cardDeck = new PlayingCard[52];
        int index = 0;

        //Creates PlayingCard-objects into cardDeck-Array with all numbers of cards for each color
        for (int suit = 0; suit <= PlayingCard.cardSuit.length-1; suit++) {
            for (int rank = 0; rank <= PlayingCard.cardRank.length-1; rank++) {
                cardDeck[index] = new PlayingCard(suit, rank, true);
                index++;
            }
        }
    }

    public void shuffleArray(PlayingCard[] arr) {

        Random rand = new Random();

        for (int i = arr.length - 1; i > 0; i--) {
            int index = rand.nextInt(i + 1);

            PlayingCard temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public PlayingCard getFirstCard() {
        //Method to get first card and then iterate through the deck
        PlayingCard drawnCard = cardDeck[firstCard];
        firstCard++;
        return drawnCard;
    }

    public PlayingCardDeck putCardBack(PlayingCardDeck deck, PlayingCard putThisBack) {
        PlayingCardDeck fullDeck = deck;
        PlayingCard atBottom = putThisBack;


        for (int i = 0; i < fullDeck.cardDeck.length; i++) {
            PlayingCard temp = fullDeck.cardDeck[i];

            for (int j = (i - 1); j >= 0; j--) {
                fullDeck.cardDeck[i + 1] = fullDeck.cardDeck[i];
            }

            fullDeck.cardDeck[i] = temp;
        }
        return fullDeck;
    }
}

/* represent a card deck of 52 card of the type PlayingCard
At least one data structure for storing PlayingCard objects (array, hashmap, linkedlist etc.
Method to take the first card from PlayingCardDeck (array[i], key, etc)
Method to put a card into the back of the deck
Handle what happens when the deck is empty
 */