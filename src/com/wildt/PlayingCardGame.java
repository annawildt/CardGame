package com.wildt;

import java.util.Scanner;

public class PlayingCardGame {

    public static void playGame() {
        PlayingCardDeck deck = createNewDeck();

        System.out.println("\nYou and the computer have both pulled a card each. " +
                "Guess if your card is higher or lower than your opponent's.");

        PlayingCard computerCard = deck.getFirstCard();
        PlayingCard playerCard = deck.getFirstCard();
        playerCard.hidden = false;

        PlayingCard winningCard = winningCard(computerCard, playerCard);

        printCurrentGameStats(computerCard, playerCard);

        System.out.println("\nWrite the number of your option:\n" +
                "1. My card is higher.\n" +
                "2. My card is lower.");

        boolean guessHigher = userGuess();

        computerCard.hidden = false;
        printCurrentGameStats(computerCard, playerCard);

        if (!guessHigher && winningCard == computerCard) {
            System.out.println("You won!\nYou correctly guessed that your card was lower than the computer's.");
        } else if (guessHigher && winningCard == playerCard) {
            System.out.println("You won!\nYou correctly guessed that your card was higher than the computer's.");
        } else if (!guessHigher && winningCard == playerCard) {
            System.out.println("You lost!\nYou guessed that the computer's card was higher but your card was higher.");
        } else if (guessHigher && winningCard == computerCard) {
            System.out.println("You lost!\nYou guessed that your card was higher but the computer's card was higher.");
        }

        replayGame();
    }

    private static boolean userGuess() {
        //Method to return a boolean depending on the user's input.
        boolean guessHigher;

        //Loop until the user input a valid answer
        while (true) {
            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();

            if (answer == 1) {
                guessHigher = true;
                break;
            } else if (answer == 2) {
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
        System.out.println("\nYour card is " + playerCard.generateCard());
        if (computerCard.hidden) {
            System.out.println("Computer's card is ??????");
        } else {
            System.out.println("Computer's card is " + computerCard.generateCard());
        }
    }

    private static PlayingCardDeck createNewDeck() {
        PlayingCardDeck deck = new PlayingCardDeck();
        deck.shuffleArray(deck.cardDeck);

        return deck;
    }

    private static void replayGame() {

        System.out.println("\nReplay game? y/n");

        while (true) {
            Scanner input = new Scanner(System.in);
            char answer = input.next().charAt(0);

            if (answer == 'y') {
                playGame();
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

/*
Create a shuffled deck to use
Choose between 1 or 2 players (if necessary)
Set conditions for win/loss/draw
Save history like high score, amount of times played etc in a text-file.
Create a menu with the following: play game, show rules, show statistics (text-file), quit game (system exit)
 */