package com.wildt;

import java.util.Collections;
import java.util.Scanner;

public class PlayingCardGame {

    public static void initializeDeck() {
        PlayingCardDeck deck = createNewDeck();

        playGame(deck);
    }

    public static void playGame(PlayingCardDeck useThisDeck) {

        PlayingCardDeck deck = useThisDeck;

        System.out.println("\nYou and the computer have both pulled a card each. " +
                "Guess if your card is higher or lower than your opponent's.");

        PlayingCard computerCard = deck.getFirstCard(deck);
        if (computerCard == null) {
            System.out.println("Deck is empty. Initializing a new deck.");
            initializeDeck();
        }
        PlayingCard playerCard = deck.getFirstCard(deck);
        if (playerCard == null) {
            System.out.println("Deck is empty. Initializing a new deck.");
            initializeDeck();
        }

        playerCard.hidden = false;

        PlayingCard winningCard = winningCard(computerCard, playerCard);

        printCurrentGameStats(computerCard, playerCard);

        System.out.println("\nWrite the number of your option:\n" +
                "1. My card is higher.\n" +
                "2. My card is lower.");

        boolean guessHigher = userGuess();
        computerCard.hidden = false;

        printCurrentGameStats(computerCard, playerCard);
        printEndGameStats(guessHigher, winningCard, computerCard, playerCard);
        replayGame(deck);
    }
    private static void printEndGameStats
            (boolean guessHigher, PlayingCard winningCard, PlayingCard computerCard, PlayingCard playerCard) {
        if (!guessHigher && winningCard == computerCard) {
            System.out.println("You won!\nYou correctly guessed that your card was lower than the computer's.");
            ReadTextFile.writeGameStatistics(1, 0);

        } else if (guessHigher && winningCard == playerCard) {
            System.out.println("You won!\nYou correctly guessed that your card was higher than the computer's.");
            ReadTextFile.writeGameStatistics(1, 0);

        } else if (!guessHigher && winningCard == playerCard) {
            System.out.println("You lost!\nYou guessed that the computer's card was higher but your card was higher.");
            ReadTextFile.writeGameStatistics(0, 1);

        } else if (guessHigher && winningCard == computerCard) {
            System.out.println("You lost!\nYou guessed that your card was higher but the computer's card was higher.");
            ReadTextFile.writeGameStatistics(0, 1);
        }
    }

    private static boolean userGuess() {
        //Method to return a boolean depending on the user's input.
        boolean guessHigher;

        while (true) {
            Scanner input = new Scanner(System.in);
            String answer = input.next();

            if (answer.equals("1")) {
                guessHigher = true;
                break;
            } else if (answer.equals("2")) {
                guessHigher = false;
                break;
            } else {
                System.out.println("Invalid answer.");
            }
        }
        return guessHigher;
    }

    private static PlayingCard winningCard(PlayingCard computerCard, PlayingCard playerCard) {
        //Method to calculate which of the two cards is the highest. If the number is the same then go for suit.

        PlayingCard winningCard = new PlayingCard(0, 0, false);

        if(computerCard.rank > playerCard.rank) {
            winningCard = computerCard;
        } else if (computerCard.rank < playerCard.rank) {
            winningCard = playerCard;
        } else if (computerCard.rank == playerCard.rank) {
            if (computerCard.suit > playerCard.suit) {
                winningCard = computerCard;
            } else if (computerCard.suit < playerCard.suit) {
                winningCard = playerCard;
            }
        }
        return winningCard;
    }

    private static void printCurrentGameStats (PlayingCard computerCard, PlayingCard playerCard) {
        //Only shows card with hidden=false

        if (playerCard.hidden) {
            System.out.println("Your card is ??????");
        } else {
            System.out.println("Your card is " + playerCard.getCardAsString());
        }

        if (computerCard.hidden) {
            System.out.println("Computer's card is ??????");
        } else {
            System.out.println("Computer's card is " + computerCard.getCardAsString());
        }
    }

    private static PlayingCardDeck createNewDeck() {
        PlayingCardDeck deck = new PlayingCardDeck();
        Collections.shuffle(deck.cardDeck);

        return deck;
    }

    private static void replayGame(PlayingCardDeck replayDeck) {

        System.out.println("\nReplay game? y/n");

        while (true) {
            Scanner input = new Scanner(System.in);
            char answer = input.next().charAt(0);

            if (answer == 'y') {
                playGame(replayDeck);
                break;
            } else if (answer == 'n'){
                Menu.startMenu();
                break;
            } else {
                System.out.println("Invalid input.");
                break;
            }
        }
    }
}
