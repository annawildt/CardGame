package com.wildt;

import java.io.*;
import java.util.Scanner;


public class ReadTextFile {

    public static void printRules() {

        File file = new File("Rules.txt");

        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            System.err.println("File not found!");
            return;
        }

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }

    public static void printGameStatistics() {
        try {
            BufferedReader inputStream = new BufferedReader((new FileReader("gamestats.txt")));
            int rowNr = 1;
            System.out.println("" +
                    "-----------------------\n" +
                    "Current game statistics\n" +
                    "1 = Total right guesses\n" +
                    "2 = Total wrong guesses\n" +
                    "3 = Total guesses made\n");
            while (true) {
                String str = inputStream.readLine();
                if (str == null) {
                    break;
                }
                System.out.println(rowNr + ": " + str);
                rowNr++;
            }
            System.out.println("-----------------------");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeGameStatistics(int rightGuess, int wrongGuess) {
        try {
            //Reads from file gamestats.txt, changes the number to correct stats, and prints to temp.txt

            BufferedReader inputStream = new BufferedReader((new FileReader("gamestats.txt")));
            PrintWriter outputStream = new PrintWriter(new BufferedWriter(new FileWriter("temp.txt")));

            while (true) {
                String row1 = inputStream.readLine();
                if (row1 == null){
                    break;
                }

                int rightGuessCounter = Integer.parseInt(row1);

                String row2 = inputStream.readLine();
                if (row2 == null) {
                    break;
                }
                int wrongGuessCounter = Integer.parseInt(row2);


                String row3 = inputStream.readLine();
                if (row3 == null) {
                    break;
                }
                int gamesPlayedCounter = Integer.parseInt(row3);
                gamesPlayedCounter++;

                outputStream.println(rightGuessCounter + rightGuess);
                outputStream.println(wrongGuessCounter + wrongGuess);
                outputStream.println(gamesPlayedCounter);
            }
            inputStream.close();
            outputStream.close();


            //Reads from temp.txt and prints to gamestats.txt

            inputStream = new BufferedReader((new FileReader("temp.txt")));
            outputStream = new PrintWriter(new BufferedWriter(new FileWriter("gamestats.txt")));

            while (true) {
                String row = inputStream.readLine();
                if (row == null) {
                    break;
                }
                outputStream.println(row);
            }

            outputStream.close();
            inputStream.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
}
