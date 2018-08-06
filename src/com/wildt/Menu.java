package com.wildt;

import java.util.Scanner;

public class Menu {
    public static void startMenu() {

        while(true) {
            printGameMenu();

            Scanner input = new Scanner(System.in);
            int answer = input.nextInt();

            switch (answer) {
                case 1:
                    PlayingCardGame.initializeDeck();
                    break;
                case 2:
                    ReadTextFile.printRules();
                    break;
                case 3:
                    ReadTextFile.printGameStatistics();
                    break;
                case 4:
                    sureToQuit();
                    break;
                default:
                    System.out.println("Invalid answer. Enter number 1-4.");
            }
        }
    }

    private static void printGameMenu() {
        String menuOptions[] = {"1. Start game",
                "2. Game rules",
                "3. Show game statistics",
                "4. Quit game"};

        System.out.println("Welcome to the card guessing game!\n" +
                "Write the number of the menu option you choose:");
        for (String menuOption : menuOptions) {
            System.out.println(menuOption);
        }

    }

    private static void sureToQuit(){
        //Method for validation to quit the program. Choosing N (no) returns the user to start menu.

        System.out.println("Are you sure you wish to exit the game? y/n");

        while (true) {
            Scanner input = new Scanner(System.in);
            char answer = input.next().charAt(0);

            if (answer == 'y') {
                System.exit(0);
                break;
            } else if (answer == 'n'){
                startMenu();
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}
