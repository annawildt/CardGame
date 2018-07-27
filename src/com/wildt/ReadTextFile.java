package com.wildt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadTextFile {

    public static void rules() {

//        File file = new File
//                ("C:\\Users\\Administrator\\Google Drive\\Academy\\Java\\PlayingCardGame\\CardGame\\Rules.txt");
        File file = new File("Rules.txt");

        Scanner sc = null;
        try{
            sc = new Scanner(file);
        }
        catch (FileNotFoundException ex){
            //ex.printStackTrace();
            System.err.println("File not found!");
            return;
        }

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
